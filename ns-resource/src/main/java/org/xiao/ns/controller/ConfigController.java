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
import org.xiao.ns.domain.po.Config;
import org.xiao.ns.service.ConfigService;

import java.util.List;

@RestController
@RequestMapping("config")
public class ConfigController implements FaceService<Config> {

    @Resource
    ConfigService configService;

    @Override
    @PostMapping("deleteOne")
    public int deleteOne(@RequestBody CommonRequest<Long> record) {
        return configService.deleteOne(record.getArgs());
    }

    @Override
    @PostMapping("deleteMany")
    public int deleteMany(@RequestBody CommonRequest<List<Long>> record) {
        return configService.deleteMany(record.getArgs());
    }

    @Override
    @PostMapping("insertOne")
    public int insertOne(@RequestBody CommonRequest<Config> record) {
        return configService.insertOne(record.getArgs());
    }

    @Override
    @PostMapping("insertMany")
    public int insertMany(@RequestBody CommonRequest<List<Config>> record) {
        return configService.insertMany(record.getArgs());
    }

    @Override
    @PostMapping("selectOne")
    public Config selectOne(@RequestBody CommonRequest<Long> record) {
        return configService.selectOne(record.getArgs());
    }

    @Override
    @PostMapping("selectMany")
    public List<? extends Config> selectMany(@RequestBody CommonRequest<Config> record) {
        return configService.selectMany(record.getArgs());
    }

    @Override
    @PostMapping("selectPage")
    public PageInfo<? extends Config> selectPage(@RequestBody CommonRequestPaging<Config> record) {
        return configService.selectPage(record.getArgs(), record.getPaging().getPageNum(), record.getPaging().getPageSize());
    }

    @Override
    @PostMapping("updateOne")
    public int updateOne(@RequestBody CommonRequest<Config> record) {
        return configService.updateOne(record.getArgs());
    }

    @Override
    @PostMapping("updateMany")
    public int updateMany(@RequestBody CommonRequest<List<Config>> record) {
        return configService.updateMany(record.getArgs());
    }

    @Override
    @PostMapping("validOne")
    public int validOne(@RequestBody CommonRequest<ArgsState<Long, String>> record) {
        return configService.validOne(record.getArgs());
    }

    @Override
    @PostMapping("validMany")
    public int validMany(@RequestBody CommonRequest<ArgsState.Many<Long, String>> record) {
        return configService.validMany(record.getArgs());
    }
}
