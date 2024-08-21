package org.xiao.ns.service.impl;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.ns.domain.po.App;
import org.xiao.ns.manage.AppManage;
import org.xiao.ns.service.AppService;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Resource
    AppManage appManage;

    @Override
    public int deleteOne(Long record) {
        return appManage.deleteOne(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return appManage.deleteMany(record);
    }

    @Override
    public int insertOne(App record) {
        return appManage.insertOne(record);
    }

    @Override
    public int insertMany(List<App> record) {
        return appManage.insertMany(record);
    }

    @Override
    public App selectOne(Long record) {
        return appManage.selectOne(record);
    }

    @Override
    public List<? extends App> selectMany(App record) {
        return appManage.selectMany(record);
    }

    @Override
    public PageInfo<? extends App> selectPage(App record, int pageNum, int pageSize) {
        return appManage.selectPage(record, pageNum, pageSize);
    }

    @Override
    public int updateOne(App record) {
        return appManage.updateOne(record);
    }

    @Override
    public int updateMany(List<App> record) {
        return appManage.updateMany(record);
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return appManage.validOne(record);
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return appManage.validMany(record);
    }
}
