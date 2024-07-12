package org.xiao.ns.service;

import org.xiao.cs.db.box.service.business.BusinessService;
import org.xiao.ns.domain.po.Permission;

public interface PermissionService extends BusinessService<Permission> {
    String[] selectIn(String source, Long[] orgIdArray, Long[] roleIdArray);
}
