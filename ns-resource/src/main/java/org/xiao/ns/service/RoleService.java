package org.xiao.ns.service;

import org.xiao.cs.db.box.service.business.BusinessService;
import org.xiao.ns.domain.po.Role;

import java.util.List;

public interface RoleService extends BusinessService<Role> {
    List<Role> selectIn(String source, Long[]  roleIdArray);
}
