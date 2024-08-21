package org.xiao.ns.service;

import org.xiao.cs.db.box.norm.among.AmongService;
import org.xiao.ns.domain.po.Route;

import java.util.List;

public interface RouteService extends AmongService<Route> {
    List<Route> selectIn(String app, Long[] menuIdArray);
}
