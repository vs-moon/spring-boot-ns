package org.xiao.ns.service;

import org.xiao.cs.db.box.norm.among.AmongService;
import org.xiao.ns.domain.po.Permission;

public interface PermissionService extends AmongService<Permission> {
    String[] selectIn(String app, Long[] permissionIdArray);
}
