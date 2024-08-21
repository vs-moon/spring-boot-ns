package org.xiao.ns.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.common.box.domain.CommonRequestPaging;
import org.xiao.cs.db.box.norm.face.FaceService;
import org.xiao.ns.domain.po.Route;
import org.xiao.ns.service.RouteService;

import java.util.List;

@RestController
@RequestMapping("route")
public class RouteController implements FaceService<Route> {

    @Resource
    RouteService routeService;

    @Override
    @PostMapping("deleteOne")
    public int deleteOne(@RequestBody CommonRequest<Long> record) {
        return routeService.deleteOne(record.getArgs());
    }

    @Override
    @PostMapping("deleteMany")
    public int deleteMany(@RequestBody CommonRequest<List<Long>> record) {
        return routeService.deleteMany(record.getArgs());
    }

    @Override
    @PostMapping("insertOne")
    public int insertOne(@RequestBody CommonRequest<Route> record) {
        return routeService.insertOne(record.getArgs());
    }

    @Override
    @PostMapping("insertMany")
    public int insertMany(@RequestBody CommonRequest<List<Route>> record) {
        return routeService.insertMany(record.getArgs());
    }

    @Override
    @PostMapping("selectOne")
    public Route selectOne(@RequestBody CommonRequest<Long> record) {
        return routeService.selectOne(record.getArgs());
    }

    @Override
    @PostMapping("selectMany")
    public List<? extends Route> selectMany(@RequestBody CommonRequest<Route> record) {
        return routeService.selectMany(record.getArgs());
    }

    @Override
    @PostMapping("selectLazy")
    public List<? extends Route> selectLazy(@RequestBody CommonRequest<Route> record) {
        return routeService.selectLazy(record.getArgs());
    }

    @Override
    @PostMapping("selectPage")
    public PageInfo<? extends Route> selectPage(@RequestBody CommonRequestPaging<Route> record) {
        return routeService.selectPage(record.getArgs(), record.getPaging().getPageNum(), record.getPaging().getPageSize());
    }

    @Override
    @PostMapping("updateOne")
    public int updateOne(@RequestBody CommonRequest<Route> record) {
        return routeService.updateOne(record.getArgs());
    }

    @Override
    @PostMapping("updateMany")
    public int updateMany(@RequestBody CommonRequest<List<Route>> record) {
        return routeService.updateMany(record.getArgs());
    }

    @Override
    @PostMapping("validOne")
    public int validOne(@RequestBody CommonRequest<ArgsState<Long, String>> record) {
        return routeService.validOne(record.getArgs());
    }

    @Override
    @PostMapping("validMany")
    public int validMany(@RequestBody CommonRequest<ArgsState.Many<Long, String>> record) {
        return routeService.validMany(record.getArgs());
    }
}
