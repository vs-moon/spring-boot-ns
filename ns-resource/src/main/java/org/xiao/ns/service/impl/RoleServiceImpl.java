package org.xiao.ns.service.impl;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.ns.domain.po.Role;
import org.xiao.ns.manage.RoleManage;
import org.xiao.ns.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleManage roleManage;

    @Override
    public String[] selectIn(String app, Long[]  ridArray) {
        return roleManage.selectIn(app, ridArray);
    }

    @Override
    public int deleteOne(Long record) {
        return roleManage.deleteOne(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return roleManage.deleteMany(record);
    }

    @Override
    public int insertOne(Role record) {
        return roleManage.insertOne(record);
    }

    @Override
    public int insertMany(List<Role> record) {
        return roleManage.insertMany(record);
    }

    @Override
    public Role selectOne(Long record) {
        return roleManage.selectOne(record);
    }

    @Override
    public List<? extends Role> selectMany(Role record) {
        return roleManage.selectMany(record);
    }

    @Override
    public PageInfo<? extends Role> selectPage(Role record, int pageNum, int pageSize) {
        return roleManage.selectPage(record, pageNum, pageSize);
    }

    @Override
    public int updateOne(Role record) {
        return roleManage.updateOne(record);
    }

    @Override
    public int updateMany(List<Role> record) {
        return roleManage.updateMany(record);
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return roleManage.validOne(record);
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return roleManage.validMany(record);
    }
}
