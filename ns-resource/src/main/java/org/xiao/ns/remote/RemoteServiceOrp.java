package org.xiao.ns.remote;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.sso.box.domain.AuthoritySymbol;
import org.xiao.ns.service.OrgService;
import org.xiao.ns.service.PermissionService;
import org.xiao.ns.service.RoleService;

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
        String app = commonRequest.getSign();
        AuthoritySymbol<Long> authoritySymbol = commonRequest.getArgs();

        String[] orgCodeArray = orgService.selectIn(app, authoritySymbol.getOrg());
        String[] roleCodeArray = roleService.selectIn(app, authoritySymbol.getRole());
        String[] permissionCodeArray = permissionService.selectIn(app, authoritySymbol.getPermission());

        return new AuthoritySymbol<>(orgCodeArray, roleCodeArray, permissionCodeArray);
    }
}
