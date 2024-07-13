package org.xiao.ns.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.common.box.domain.CommonRequestPaging;
import org.xiao.cs.db.box.norm.face.FaceService;
import org.xiao.ns.domain.po.Dic;
import org.xiao.ns.service.DicService;

import java.util.List;

@RestController
@RequestMapping("dic")
public class DicController implements FaceService<Dic> {

    @Resource
    DicService dicService;

    @Override
    @PostMapping("deleteOne")
    public int deleteOne(@RequestBody CommonRequest<Long> record) {
        return dicService.deleteOne(record.getArgs());
    }

    @Override
    @PostMapping("deleteMany")
    public int deleteMany(@RequestBody CommonRequest<List<Long>> record) {
        return dicService.deleteMany(record.getArgs());
    }

    @Override
    @PostMapping("insertOne")
    public int insertOne(@RequestBody CommonRequest<Dic> record) {
        return dicService.insertOne(record.getArgs());
    }

    @Override
    @PostMapping("insertMany")
    public int insertMany(@RequestBody CommonRequest<List<Dic>> record) {
        return dicService.insertMany(record.getArgs());
    }

    @Override
    @PostMapping("selectOne")
    public Dic selectOne(@RequestBody CommonRequest<Long> record) {
        return dicService.selectOne(record.getArgs());
    }

    @Override
    @PostMapping("selectMany")
    public List<? extends Dic> selectMany(@RequestBody CommonRequest<Dic> record) {
        return dicService.selectMany(record.getArgs());
    }

    @Override
    @PostMapping("selectPage")
    public PageInfo<? extends Dic> selectPage(@RequestBody CommonRequestPaging<Dic> record) {
        return dicService.selectPage(record.getArgs(), record.getPaging().getPageNum(), record.getPaging().getPageSize());
    }

    @Override
    @PostMapping("updateOne")
    public int updateOne(@RequestBody CommonRequest<Dic> record) {
        return dicService.updateOne(record.getArgs());
    }

    @Override
    @PostMapping("updateMany")
    public int updateMany(@RequestBody CommonRequest<List<Dic>> record) {
        return dicService.updateMany(record.getArgs());
    }

    @Override
    @PostMapping("validOne")
    public int validOne(@RequestBody CommonRequest<ArgsState<Long, String>> record) {
        return dicService.validOne(record.getArgs());
    }

    @Override
    @PostMapping("validMany")
    public int validMany(@RequestBody CommonRequest<ArgsState.Many<Long, String>> record) {
        return dicService.validMany(record.getArgs());
    }
}
