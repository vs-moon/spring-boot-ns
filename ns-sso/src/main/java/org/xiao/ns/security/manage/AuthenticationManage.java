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
    MemberMapper memberMapper;
    @Resource
    NexusOrgMemberMapper nexusOrgMemberMapper;
    @Resource
    NexusOrgPermissionMapper nexusOrgPermissionMapper;
    @Resource
    NexusRoleMemberMapper nexusRoleMemberMapper;
    @Resource
    NexusRolePermissionMapper nexusRolePermissionMapper;
    @Resource
    private NexusRoleMenuMapper nexusRoleMenuMapper;
    @Resource
    RemoteServiceNSResource remoteServiceNSResource;

    public AccountBody loadUserByUsername(String username) {
        AccountBody accountBody = new AccountBody();
        AccountBody.Basic basic = new AccountBody.Basic();
        AccountBody.Expand expand = new AccountBody.Expand();

        // 获取成员信息
        Optional<Member> optionalMember = getMember(username);

        if (optionalMember.isEmpty()) {
            return null;
        } else {
            BeanUtils.copyProperties(optionalMember.get(), basic);
            accountBody.setBasic(basic);
        }

        // 获取组织、角色、权限等关联ID
        Long[] orgIdArray = getOrgIdArray(basic.getId());
        Long[] roleIdArray = getRoleIdArray(basic.getId());
        Long[] permissionIdArray = getPermissionIdArray(orgIdArray, roleIdArray);

        // 根据 ID 调用资源服务, 从资源库中获取对应的 CODE
        AuthoritySymbol<String> authoritySymbol = remoteServiceNSResource.orpSelect(CommonRequest.builder(new AuthoritySymbol<>(orgIdArray, roleIdArray, permissionIdArray))).getData();

        if (authoritySymbol != null) {
            accountBody.setAuthoritySymbol(authoritySymbol);
        }

        return accountBody;
    }

    public Optional<Member> getMember(String username) {
        return memberMapper.selectOne(m -> m.where(MemberDynamicSqlSupport.username, isEqualTo(username)));
    }

    public Long[] getOrgIdArray(Long memberId) {
        SelectStatementProvider select = select(NexusOrgMemberDynamicSqlSupport.orgId)
                .from(NexusOrgMemberDynamicSqlSupport.nexusOrgMember)
                .where()
                .and(NexusOrgMemberDynamicSqlSupport.memberId, isEqualTo(memberId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<NexusOrgMember> nexusOrgMembers = nexusOrgMemberMapper.selectMany(select);
        return nexusOrgMembers.stream().map(NexusOrgMember::getOrgId).toArray(Long[]::new);
    }

    public Long[] getRoleIdArray(Long memberId) {
        SelectStatementProvider select = select(NexusRoleMemberDynamicSqlSupport.roleId)
                .from(NexusRoleMemberDynamicSqlSupport.nexusRoleMember)
                .where()
                .and(NexusRoleMemberDynamicSqlSupport.memberId, isEqualTo(memberId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<NexusRoleMember> nexusRoleMembers = nexusRoleMemberMapper.selectMany(select);
        return nexusRoleMembers.stream().map(NexusRoleMember::getRoleId).toArray(Long[]::new);
    }

    public Long[] getPermissionIdArray(Long[] orgIdArray, Long[] roleIdArray) {
        Long[] nexusOrgPermissionsIdArray = null;
        Long[] nexusRolePermissionsIdArray = null;

        if (ArrayUtils.isNotEmpty(orgIdArray)) {
            SelectStatementProvider selectNexusOrgPermission = select(NexusOrgPermissionDynamicSqlSupport.permissionId)
                    .from(NexusOrgPermissionDynamicSqlSupport.nexusOrgPermission)
                    .where()
                    .and(NexusOrgPermissionDynamicSqlSupport.orgId, isInWhenPresent(orgIdArray))
                    .build()
                    .render(RenderingStrategies.MYBATIS3);

            nexusOrgPermissionsIdArray = nexusOrgPermissionMapper.selectMany(selectNexusOrgPermission)
                    .stream()
                    .map(NexusOrgPermission::getPermissionId)
                    .toArray(Long[]::new);
        }

        if (ArrayUtils.isNotEmpty(roleIdArray)) {
            SelectStatementProvider selectNexusRolePermission = select(NexusRolePermissionDynamicSqlSupport.permissionId)
                    .from(NexusRolePermissionDynamicSqlSupport.nexusRolePermission)
                    .where()
                    .and(NexusRolePermissionDynamicSqlSupport.roleId, isInWhenPresent(roleIdArray))
                    .build()
                    .render(RenderingStrategies.MYBATIS3);

            nexusRolePermissionsIdArray = nexusRolePermissionMapper.selectMany(selectNexusRolePermission)
                    .stream()
                    .map(NexusRolePermission::getPermissionId)
                    .toArray(Long[]::new);
        }

        return ArrayUtils.addAll(nexusOrgPermissionsIdArray, nexusRolePermissionsIdArray);
    }

    public Long [] getRoleMenuIdArray() {
        Long memberId = tokenUtils.toBean().getId();
        Long[] roleIdArray = getRoleIdArray(memberId);
        SelectStatementProvider render = select(NexusRoleMenuDynamicSqlSupport.menuId)
                .from(NexusRoleMenuDynamicSqlSupport.nexusRoleMenu)
                .where(NexusRoleMenuDynamicSqlSupport.roleId, isIn(roleIdArray))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return nexusRoleMenuMapper.selectMany(render).stream().map(NexusRoleMenu::getMenuId).toArray(Long[]::new);

    }

    public Object getRoute() {
        Long[] roleMenuIdArray = getRoleMenuIdArray();
        return remoteServiceNSResource.menuSelect(CommonRequest.builder(roleMenuIdArray)).getData();
    }
}
