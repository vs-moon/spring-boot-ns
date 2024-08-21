package org.xiao.ns.service.impl;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.ns.domain.po.User;
import org.xiao.ns.manage.UserManage;
import org.xiao.ns.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserManage userManage;

    @Override
    public int deleteOne(Long record) {
        return userManage.deleteOne(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return userManage.deleteMany(record);
    }

    @Override
    public int insertOne(User record) {
        return userManage.insertOne(record);
    }

    @Override
    public int insertMany(List<User> record) {
        return userManage.insertMany(record);
    }

    @Override
    public User selectOne(Long record) {
        return userManage.selectOne(record);
    }

    @Override
    public List<? extends User> selectMany(User record) {
        return userManage.selectMany(record);
    }

    @Override
    public PageInfo<? extends User> selectPage(User record, int pageNum, int pageSize) {
        return userManage.selectPage(record, pageNum, pageSize);
    }

    @Override
    public int updateOne(User record) {
        return userManage.updateOne(record);
    }

    @Override
    public int updateMany(List<User> record) {
        return userManage.updateMany(record);
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return userManage.validOne(record);
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return userManage.validMany(record);
    }
}
