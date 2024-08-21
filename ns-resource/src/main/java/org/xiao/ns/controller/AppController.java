package org.xiao.ns.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.common.box.domain.CommonRequestPaging;
import org.xiao.cs.db.box.norm.face.FaceService;
import org.xiao.ns.domain.po.App;
import org.xiao.ns.service.AppService;

import java.util.List;

@RestController
@RequestMapping("app")
public class AppController implements FaceService<App> {

    @Resource
    AppService appService;

    @Override
    @PostMapping("deleteOne")
    public int deleteOne(@RequestBody CommonRequest<Long> record) {
        return appService.deleteOne(record.getArgs());
    }

    @Override
    @PostMapping("deleteMany")
    public int deleteMany(@RequestBody CommonRequest<List<Long>> record) {
        return appService.deleteMany(record.getArgs());
    }

    @Override
    @PostMapping("insertOne")
    public int insertOne(@RequestBody CommonRequest<App> record) {
        return appService.insertOne(record.getArgs());
    }

    @Override
    @PostMapping("insertMany")
    public int insertMany(@RequestBody CommonRequest<List<App>> record) {
        return appService.insertMany(record.getArgs());
    }

    @Override
    @PostMapping("selectOne")
    public App selectOne(@RequestBody CommonRequest<Long> record) {
        return appService.selectOne(record.getArgs());
    }

    @Override
    @PostMapping("selectMany")
    public List<? extends App> selectMany(@RequestBody CommonRequest<App> record) {
        return appService.selectMany(record.getArgs());
    }

    @Override
    @PostMapping("selectPage")
    public PageInfo<? extends App> selectPage(@RequestBody CommonRequestPaging<App> record) {
        return appService.selectPage(record.getArgs(), record.getPaging().getPageNum(), record.getPaging().getPageSize());
    }

    @Override
    @PostMapping("updateOne")
    public int updateOne(@RequestBody CommonRequest<App> record) {
        return appService.updateOne(record.getArgs());
    }

    @Override
    @PostMapping("updateMany")
    public int updateMany(@RequestBody CommonRequest<List<App>> record) {
        return appService.updateMany(record.getArgs());
    }

    @Override
    @PostMapping("validOne")
    public int validOne(@RequestBody CommonRequest<ArgsState<Long, String>> record) {
        return appService.validOne(record.getArgs());
    }

    @Override
    @PostMapping("validMany")
    public int validMany(@RequestBody CommonRequest<ArgsState.Many<Long, String>> record) {
        return appService.validMany(record.getArgs());
    }
}
