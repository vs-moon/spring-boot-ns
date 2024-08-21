package org.xiao.ns.security.manage;

import jakarta.annotation.Resource;
import org.apache.commons.lang3.ArrayUtils;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.sso.box.domain.AccountBody;
import org.xiao.cs.sso.box.domain.AuthoritySymbol;
import org.xiao.cs.sso.box.utils.TokenUtils;
import org.xiao.ns.domain.po.*;
import org.xiao.ns.mapper.*;
import org.xiao.ns.RemoteServiceNSResource;

import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class AuthenticationManage {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationManage.class);
    @Resource
    TokenUtils tokenUtils;
    @Resource
    UserMapper memberMapper;
    @Resource
    NexusOrgUserMapper nexusOrgUserMapper;
    @Resource
    NexusOrgPermissionMapper nexusOrgPermissionMapper;
    @Resource
    NexusRoleUserMapper nexusRoleUserMapper;
    @Resource
    NexusRolePermissionMapper nexusRolePermissionMapper;
    @Resource
    private NexusRoleRouteMapper nexusRoleRouteMapper;
    @Resource
    RemoteServiceNSResource remoteServiceNSResource;

    public AccountBody loadUserByUsername(String username) {
        AccountBody accountBody = new AccountBody();
        AccountBody.Basic basic = new AccountBody.Basic();

        // 获取成员信息
        Optional<User> optionalUser = getUser(username);

        if (optionalUser.isEmpty()) {
            return null;
        } else {
            BeanUtils.copyProperties(optionalUser.get(), basic);
            accountBody.setBasic(basic);
        }

        // 获取组织、角色、权限等关联ID
        Long[] oidArray = getOidArray(basic.getId());
        Long[] ridArray = getRidArray(basic.getId());
        Long[] permissionIdArray = getPermissionIdArray(oidArray, ridArray);

        // 根据 ID 调用资源服务, 从资源库中获取对应的 CODE
        AuthoritySymbol<String> authoritySymbol = remoteServiceNSResource.orpSelect(CommonRequest.builder(new AuthoritySymbol<>(oidArray, ridArray, permissionIdArray))).getData();

        if (authoritySymbol != null) {
            accountBody.setAuthoritySymbol(authoritySymbol);
        }

        return accountBody;
    }

    public Optional<User> getUser(String username) {
        return memberMapper.selectOne(m -> m.where(UserDynamicSqlSupport.username, isEqualTo(username)));
    }

    public Long[] getOidArray(Long memberId) {
        SelectStatementProvider select = select(NexusOrgUserDynamicSqlSupport.oid)
                .from(NexusOrgUserDynamicSqlSupport.nexusOrgUser)
                .where()
                .and(NexusOrgUserDynamicSqlSupport.uid, isEqualTo(memberId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<NexusOrgUser> nexusOrgUsers = nexusOrgUserMapper.selectMany(select);
        return nexusOrgUsers.stream().map(NexusOrgUser::getOid).toArray(Long[]::new);
    }

    public Long[] getRidArray(Long memberId) {
        SelectStatementProvider select = select(NexusRoleUserDynamicSqlSupport.rid)
                .from(NexusRoleUserDynamicSqlSupport.nexusRoleUser)
                .where()
                .and(NexusRoleUserDynamicSqlSupport.uid, isEqualTo(memberId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<NexusRoleUser> nexusRoleUsers = nexusRoleUserMapper.selectMany(select);
        return nexusRoleUsers.stream().map(NexusRoleUser::getRid).toArray(Long[]::new);
    }

    public Long[] getPermissionIdArray(Long[] oidArray, Long[] ridArray) {
        Long[] nexusOrgPermissionsIdArray = null;
        Long[] nexusRolePermissionsIdArray = null;

        if (ArrayUtils.isNotEmpty(oidArray)) {
            SelectStatementProvider selectNexusOrgPermission = select(NexusOrgPermissionDynamicSqlSupport.permissionId)
                    .from(NexusOrgPermissionDynamicSqlSupport.nexusOrgPermission)
                    .where()
                    .and(NexusOrgPermissionDynamicSqlSupport.oid, isInWhenPresent(oidArray))
                    .build()
                    .render(RenderingStrategies.MYBATIS3);

            nexusOrgPermissionsIdArray = nexusOrgPermissionMapper.selectMany(selectNexusOrgPermission)
                    .stream()
                    .map(NexusOrgPermission::getPermissionId)
                    .toArray(Long[]::new);
        }

        if (ArrayUtils.isNotEmpty(ridArray)) {
            SelectStatementProvider selectNexusRolePermission = select(NexusRolePermissionDynamicSqlSupport.permissionId)
                    .from(NexusRolePermissionDynamicSqlSupport.nexusRolePermission)
                    .where()
                    .and(NexusRolePermissionDynamicSqlSupport.rid, isInWhenPresent(ridArray))
                    .build()
                    .render(RenderingStrategies.MYBATIS3);

            nexusRolePermissionsIdArray = nexusRolePermissionMapper.selectMany(selectNexusRolePermission)
                    .stream()
                    .map(NexusRolePermission::getPermissionId)
                    .toArray(Long[]::new);
        }

        return ArrayUtils.addAll(nexusOrgPermissionsIdArray, nexusRolePermissionsIdArray);
    }

    public Long [] getRouteIdArray() {
        Long memberId = tokenUtils.toBean().getId();
        Long[] ridArray = getRidArray(memberId);
        SelectStatementProvider render = select(NexusRoleRouteDynamicSqlSupport.routeId)
                .from(NexusRoleRouteDynamicSqlSupport.nexusRoleRoute)
                .where(NexusRoleRouteDynamicSqlSupport.nexusRoleRoute.column("0"), isEqualTo("0"))
                .and(NexusRoleRouteDynamicSqlSupport.rid, isInWhenPresent(ridArray))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return nexusRoleRouteMapper.selectMany(render).stream().map(NexusRoleRoute::getRouteId).toArray(Long[]::new);

    }

    public Object getRoute() {
        Long[] routeIdArray = getRouteIdArray();
        return remoteServiceNSResource.menuSelect(CommonRequest.builder(routeIdArray)).getData();
    }
}
