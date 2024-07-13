package org.xiao.ns.service;

import org.xiao.cs.db.box.norm.among.AmongService;
import org.xiao.ns.domain.po.Role;

import java.util.List;

public interface RoleService extends AmongService<Role> {
    List<Role> selectIn(String source, Long[]  roleIdArray);
}
