package org.xiao.ns.service.impl;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.ns.domain.po.Api;
import org.xiao.ns.manage.ApiManage;
import org.xiao.ns.service.ApiService;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Resource
    ApiManage apiManage;

    @Override
    public int deleteOne(Long record) {
        return apiManage.deleteOne(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return apiManage.deleteMany(record);
    }

    @Override
    public int insertOne(Api record) {
        return apiManage.insertOne(record);
    }

    @Override
    public int insertMany(List<Api> record) {
        return apiManage.insertMany(record);
    }

    @Override
    public Api selectOne(Long record) {
        return apiManage.selectOne(record);
    }

    @Override
    public List<? extends Api> selectMany(Api record) {
        return apiManage.selectMany(record);
    }

    @Override
    public PageInfo<? extends Api> selectPage(Api record, int pageNum, int pageSize) {
        return apiManage.selectPage(record, pageNum, pageSize);
    }

    @Override
    public int updateOne(Api record) {
        return apiManage.updateOne(record);
    }

    @Override
    public int updateMany(List<Api> record) {
        return apiManage.updateMany(record);
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return apiManage.validOne(record);
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return apiManage.validMany(record);
    }
}
