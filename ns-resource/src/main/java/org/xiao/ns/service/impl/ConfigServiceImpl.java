package org.xiao.ns.service.impl;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.ns.domain.po.Config;
import org.xiao.ns.manage.ConfigManage;
import org.xiao.ns.service.ConfigService;

import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Resource
    ConfigManage configManage;

    @Override
    public int deleteOne(Long record) {
        return configManage.deleteOne(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return configManage.deleteMany(record);
    }

    @Override
    public int insertOne(Config record) {
        return configManage.insertOne(record);
    }

    @Override
    public int insertMany(List<Config> record) {
        return configManage.insertMany(record);
    }

    @Override
    public Config selectOne(Long record) {
        return configManage.selectOne(record);
    }

    @Override
    public List<? extends Config> selectMany(Config record) {
        return configManage.selectMany(record);
    }

    @Override
    public PageInfo<? extends Config> selectPage(Config record, int pageNum, int pageSize) {
        return configManage.selectPage(record, pageNum, pageSize);
    }

    @Override
    public int updateOne(Config record) {
        return configManage.updateOne(record);
    }

    @Override
    public int updateMany(List<Config> record) {
        return configManage.updateMany(record);
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return configManage.validOne(record);
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return configManage.validMany(record);
    }
}
