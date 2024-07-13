package org.xiao.ns.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.common.box.domain.CommonRequestPaging;
import org.xiao.cs.db.box.norm.face.FaceService;
import org.xiao.ns.domain.po.DicType;
import org.xiao.ns.service.DicTypeService;

import java.util.List;

@RestController
@RequestMapping("dicType")
public class DicTypeController implements FaceService<DicType> {

    @Resource
    DicTypeService dicTypeService;

    @Override
    @PostMapping("deleteOne")
    public int deleteOne(@RequestBody CommonRequest<Long> record) {
        return dicTypeService.deleteOne(record.getArgs());
    }

    @Override
    @PostMapping("deleteMany")
    public int deleteMany(@RequestBody CommonRequest<List<Long>> record) {
        return dicTypeService.deleteMany(record.getArgs());
    }

    @Override
    @PostMapping("insertOne")
    public int insertOne(@RequestBody CommonRequest<DicType> record) {
        return dicTypeService.insertOne(record.getArgs());
    }

    @Override
    @PostMapping("insertMany")
    public int insertMany(@RequestBody CommonRequest<List<DicType>> record) {
        return dicTypeService.insertMany(record.getArgs());
    }

    @Override
    @PostMapping("selectOne")
    public DicType selectOne(@RequestBody CommonRequest<Long> record) {
        return dicTypeService.selectOne(record.getArgs());
    }

    @Override
    @PostMapping("selectMany")
    public List<? extends DicType> selectMany(@RequestBody CommonRequest<DicType> record) {
        return dicTypeService.selectMany(record.getArgs());
    }

    @Override
    @PostMapping("selectPage")
    public PageInfo<? extends DicType> selectPage(@RequestBody CommonRequestPaging<DicType> record) {
        return dicTypeService.selectPage(record.getArgs(), record.getPaging().getPageNum(), record.getPaging().getPageSize());
    }

    @Override
    @PostMapping("updateOne")
    public int updateOne(@RequestBody CommonRequest<DicType> record) {
        return dicTypeService.updateOne(record.getArgs());
    }

    @Override
    @PostMapping("updateMany")
    public int updateMany(@RequestBody CommonRequest<List<DicType>> record) {
        return dicTypeService.updateMany(record.getArgs());
    }

    @Override
    @PostMapping("validOne")
    public int validOne(@RequestBody CommonRequest<ArgsState<Long, String>> record) {
        return dicTypeService.validOne(record.getArgs());
    }

    @Override
    @PostMapping("validMany")
    public int validMany(@RequestBody CommonRequest<ArgsState.Many<Long, String>> record) {
        return dicTypeService.validMany(record.getArgs());
    }
}
