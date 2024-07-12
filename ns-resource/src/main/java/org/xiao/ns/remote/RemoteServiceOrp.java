package org.xiao.ns.remote;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.sso.box.domain.AuthoritySymbol;
import org.xiao.ns.domain.po.Org;
import org.xiao.ns.domain.po.Role;
import org.xiao.ns.service.OrgService;
import org.xiao.ns.service.PermissionService;
import org.xiao.ns.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/remote/orp")
public class RemoteServiceOrp {
    @Resource
    OrgService orgService;
    @Resource
    RoleService roleService;
    @Resource
    PermissionService permissionService;

    @PostMapping("/select")
    public AuthoritySymbol<String> select(@RequestBody CommonRequest<AuthoritySymbol<Long>> commonRequest) {
        String source = commonRequest.getSign();
        AuthoritySymbol<Long> authoritySymbol = commonRequest.getArgs();

        List<Org> org = orgService.selectIn(source, authoritySymbol.getOrg());

        Long[] orgIdArray = org
                .stream()
                .map(Org::getId)
                .toArray(Long[]::new);

        String[] orgCodeArray = org
                .stream()
                .map(Org::getCode)
                .toArray(String[]::new);

        List<Role> role = roleService.selectIn(source, authoritySymbol.getRole());

        Long[] roleIdArray = role
                .stream()
                .map(Role::getId)
                .toArray(Long[]::new);

        String[] roleCodeArray = role
                .stream()
                .map(Role::getCode)
                .toArray(String[]::new);

        String[] permissionCodeArray = permissionService.selectIn(source, orgIdArray, roleIdArray);

        return new AuthoritySymbol<>(orgCodeArray, roleCodeArray, permissionCodeArray);
    }
}
