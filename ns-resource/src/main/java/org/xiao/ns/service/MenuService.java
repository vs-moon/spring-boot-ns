package org.xiao.ns.service;

import org.xiao.cs.db.box.norm.among.AmongService;
import org.xiao.ns.domain.po.Menu;

import java.util.List;

public interface MenuService extends AmongService<Menu> {
    List<Menu> selectIn(String source, Long[] menuIdArray);
}
