package org.xiao.ns.service;

import org.xiao.cs.db.box.service.business.BusinessService;
import org.xiao.ns.domain.po.Menu;

import java.util.List;

public interface MenuService extends BusinessService<Menu> {
    List<Menu> selectIn(String source, Long[] menuIdArray);
}
