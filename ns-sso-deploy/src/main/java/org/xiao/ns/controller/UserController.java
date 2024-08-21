package org.xiao.ns.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.common.box.domain.CommonRequestPaging;
import org.xiao.cs.db.box.norm.face.FaceService;
import org.xiao.ns.domain.po.User;
import org.xiao.ns.service.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController implements FaceService<User> {

    @Resource
    UserService userService;

    @Override
    @PostMapping("deleteOne")
    public int deleteOne(@RequestBody CommonRequest<Long> record) {
        return userService.deleteOne(record.getArgs());
    }

    @Override
    @PostMapping("deleteMany")
    public int deleteMany(@RequestBody CommonRequest<List<Long>> record) {
        return userService.deleteMany(record.getArgs());
    }

    @Override
    @PostMapping("insertOne")
    public int insertOne(@RequestBody CommonRequest<User> record) {
        return userService.insertOne(record.getArgs());
    }

    @Override
    @PostMapping("insertMany")
    public int insertMany(@RequestBody CommonRequest<List<User>> record) {
        return userService.insertMany(record.getArgs());
    }

    @Override
    @PostMapping("selectOne")
    public User selectOne(@RequestBody CommonRequest<Long> record) {
        return userService.selectOne(record.getArgs());
    }

    @Override
    @PostMapping("selectMany")
    public List<? extends User> selectMany(@RequestBody CommonRequest<User> record) {
        return userService.selectMany(record.getArgs());
    }

    @Override
    @PostMapping("selectPage")
    public PageInfo<? extends User> selectPage(@RequestBody CommonRequestPaging<User> record) {
        return userService.selectPage(record.getArgs(), record.getPaging().getPageNum(), record.getPaging().getPageSize());
    }

    @Override
    @PostMapping("updateOne")
    public int updateOne(@RequestBody CommonRequest<User> record) {
        return userService.updateOne(record.getArgs());
    }

    @Override
    @PostMapping("updateMany")
    public int updateMany(@RequestBody CommonRequest<List<User>> record) {
        return userService.updateMany(record.getArgs());
    }

    @Override
    @PostMapping("validOne")
    public int validOne(@RequestBody CommonRequest<ArgsState<Long, String>> record) {
        return userService.validOne(record.getArgs());
    }

    @Override
    @PostMapping("validMany")
    public int validMany(@RequestBody CommonRequest<ArgsState.Many<Long, String>> record) {
        return userService.validMany(record.getArgs());
    }
}
