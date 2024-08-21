package org.xiao.ns.service;

import org.xiao.cs.db.box.norm.among.AmongService;
import org.xiao.ns.domain.po.Org;

public interface OrgService extends AmongService<Org> {
    String[] selectIn(String app, Long[] oidArray);
}
