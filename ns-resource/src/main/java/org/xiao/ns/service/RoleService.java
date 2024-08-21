package org.xiao.ns.service;

import org.xiao.cs.db.box.norm.among.AmongService;
import org.xiao.ns.domain.po.Role;


public interface RoleService extends AmongService<Role> {
    String[] selectIn(String app, Long[]  ridArray);
}
