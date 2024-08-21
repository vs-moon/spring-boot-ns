package org.xiao.ns.service.impl;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.common.box.utils.FunctionUtils;
import org.xiao.ns.domain.po.Route;
import org.xiao.ns.domain.vo.RouteVO;
import org.xiao.ns.manage.RouteManage;
import org.xiao.ns.service.RouteService;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Resource
    RouteManage routeManage;

    @Override
    public int deleteOne(Long record) {
        return routeManage.deleteOne(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return routeManage.deleteMany(record);
    }

    @Override
    public int insertOne(Route record) {
        return routeManage.insertOne(record);
    }

    @Override
    public int insertMany(List<Route> record) {
        return routeManage.insertMany(record);
    }

    @Override
    public Route selectOne(Long record) {
        return routeManage.selectOne(record);
    }

    @Override
    public List<? extends Route> selectMany(Route record) {
        return routeManage.selectMany(record);
    }

    @Override
    public List<? extends Route> selectLazy(Route record) {
        return FunctionUtils.reBuild(routeManage.selectLazy(record), menu -> FunctionUtils.reBuild(menu, RouteVO::new, (routeVO) -> {
            if (routeManage.countByKey(menu.getId()) > 0) {
                routeVO.setHasChildren(true);
            }
        }));
    }

    @Override
    public PageInfo<? extends Route> selectPage(Route record, int pageNum, int pageSize) {
        return routeManage.selectPage(record, pageNum, pageSize).convert(menu -> FunctionUtils.reBuild(menu, RouteVO::new, (menuVO) -> {
            if (routeManage.countByKey(menu.getId()) > 0) {
                menuVO.setHasChildren(true);
            }
        }));
    }

    @Override
    public int updateOne(Route record) {
        return routeManage.updateOne(record);
    }

    @Override
    public int updateMany(List<Route> record) {
        return routeManage.updateMany(record);
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return routeManage.validOne(record);
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return routeManage.validMany(record);
    }

    @Override
    public List<Route> selectIn(String app, Long[] menuIdArray) {
        return routeManage.selectIn(app, menuIdArray);
    }
}
