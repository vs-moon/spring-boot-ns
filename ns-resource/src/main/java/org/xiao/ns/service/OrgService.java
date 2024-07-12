package org.xiao.ns.service;

import org.xiao.cs.db.box.service.business.BusinessService;
import org.xiao.ns.domain.po.Org;

import java.util.List;

public interface OrgService extends BusinessService<Org> {
    List<Org> selectIn(String source, Long[] orgIdArray);
}
