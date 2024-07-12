package org.xiao.ns.remote;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.sso.box.domain.AuthoritySymbol;
import org.xiao.ns.domain.po.Menu;
import org.xiao.ns.domain.po.Org;
import org.xiao.ns.domain.po.Role;
import org.xiao.ns.service.MenuService;
import org.xiao.ns.service.OrgService;
import org.xiao.ns.service.PermissionService;
import org.xiao.ns.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/remote/menu")
public class RemoteServiceMenu {
    @Resource
    MenuService menuService;

    @PostMapping("/select")
    public List<Menu> assemble(@RequestBody CommonRequest<Long[]> commonRequest) {
        String source = commonRequest.getSign();
        return menuService.selectIn(source, commonRequest.getArgs());
    }
}
