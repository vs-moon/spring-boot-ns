package org.xiao.ns.service.impl;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.ns.domain.po.Permission;
import org.xiao.ns.manage.PermissionManage;
import org.xiao.ns.service.PermissionService;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    PermissionManage permissionManage;


    @Override
    public String[] selectIn(String app, Long[] permissionIdArray) {
        return permissionManage.selectIn(app, permissionIdArray);
    }

    @Override
    public int deleteOne(Long record) {
        return permissionManage.deleteOne(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return permissionManage.deleteMany(record);
    }

    @Override
    public int insertOne(Permission record) {
        return permissionManage.insertOne(record);
    }

    @Override
    public int insertMany(List<Permission> record) {
        return permissionManage.insertMany(record);
    }

    @Override
    public Permission selectOne(Long record) {
        return permissionManage.selectOne(record);
    }

    @Override
    public List<? extends Permission> selectMany(Permission record) {
        return permissionManage.selectMany(record);
    }

    @Override
    public PageInfo<? extends Permission> selectPage(Permission record, int pageNum, int pageSize) {
        return permissionManage.selectPage(record, pageNum, pageSize);
    }

    @Override
    public int updateOne(Permission record) {
        return permissionManage.updateOne(record);
    }

    @Override
    public int updateMany(List<Permission> record) {
        return permissionManage.updateMany(record);
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return permissionManage.validOne(record);
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return permissionManage.validMany(record);
    }
}
