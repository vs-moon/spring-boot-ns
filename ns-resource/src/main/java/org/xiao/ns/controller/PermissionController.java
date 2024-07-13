package org.xiao.ns.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.common.box.domain.CommonRequestPaging;
import org.xiao.cs.db.box.norm.face.FaceService;
import org.xiao.ns.domain.po.Permission;
import org.xiao.ns.service.PermissionService;

import java.util.List;

@RestController
@RequestMapping("permission")
public class PermissionController implements FaceService<Permission> {

    @Resource
    PermissionService permissionService;

    @Override
    @PostMapping("deleteOne")
    public int deleteOne(@RequestBody CommonRequest<Long> record) {
        return permissionService.deleteOne(record.getArgs());
    }

    @Override
    @PostMapping("deleteMany")
    public int deleteMany(@RequestBody CommonRequest<List<Long>> record) {
        return permissionService.deleteMany(record.getArgs());
    }

    @Override
    @PostMapping("insertOne")
    public int insertOne(@RequestBody CommonRequest<Permission> record) {
        return permissionService.insertOne(record.getArgs());
    }

    @Override
    @PostMapping("insertMany")
    public int insertMany(@RequestBody CommonRequest<List<Permission>> record) {
        return permissionService.insertMany(record.getArgs());
    }

    @Override
    @PostMapping("selectOne")
    public Permission selectOne(@RequestBody CommonRequest<Long> record) {
        return permissionService.selectOne(record.getArgs());
    }

    @Override
    @PostMapping("selectMany")
    public List<? extends Permission> selectMany(@RequestBody CommonRequest<Permission> record) {
        return permissionService.selectMany(record.getArgs());
    }

    @Override
    @PostMapping("selectPage")
    public PageInfo<? extends Permission> selectPage(@RequestBody CommonRequestPaging<Permission> record) {
        return permissionService.selectPage(record.getArgs(), record.getPaging().getPageNum(), record.getPaging().getPageSize());
    }

    @Override
    @PostMapping("updateOne")
    public int updateOne(@RequestBody CommonRequest<Permission> record) {
        return permissionService.updateOne(record.getArgs());
    }

    @Override
    @PostMapping("updateMany")
    public int updateMany(@RequestBody CommonRequest<List<Permission>> record) {
        return permissionService.updateMany(record.getArgs());
    }

    @Override
    @PostMapping("validOne")
    public int validOne(@RequestBody CommonRequest<ArgsState<Long, String>> record) {
        return permissionService.validOne(record.getArgs());
    }

    @Override
    @PostMapping("validMany")
    public int validMany(@RequestBody CommonRequest<ArgsState.Many<Long, String>> record) {
        return permissionService.validMany(record.getArgs());
    }
}
