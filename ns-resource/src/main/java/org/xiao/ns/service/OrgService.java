package org.xiao.ns.service;

import org.xiao.cs.db.box.norm.among.AmongService;
import org.xiao.ns.domain.po.Org;

import java.util.List;

public interface OrgService extends AmongService<Org> {
    List<Org> selectIn(String source, Long[] orgIdArray);
}
