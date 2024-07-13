package org.xiao.ns.service.impl;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.ns.domain.po.Dic;
import org.xiao.ns.manage.DicManage;
import org.xiao.ns.service.DicService;

import java.util.List;

@Service
public class DicServiceImpl implements DicService {

    @Resource
    DicManage dicManage;

    @Override
    public int deleteOne(Long record) {
        return dicManage.deleteOne(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return dicManage.deleteMany(record);
    }

    @Override
    public int insertOne(Dic record) {
        return dicManage.insertOne(record);
    }

    @Override
    public int insertMany(List<Dic> record) {
        return dicManage.insertMany(record);
    }

    @Override
    public Dic selectOne(Long record) {
        return dicManage.selectOne(record);
    }

    @Override
    public List<? extends Dic> selectMany(Dic record) {
        return dicManage.selectMany(record);
    }

    @Override
    public PageInfo<? extends Dic> selectPage(Dic record, int pageNum, int pageSize) {
        return dicManage.selectPage(record, pageNum, pageSize);
    }

    @Override
    public int updateOne(Dic record) {
        return dicManage.updateOne(record);
    }

    @Override
    public int updateMany(List<Dic> record) {
        return dicManage.updateMany(record);
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return dicManage.validOne(record);
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return dicManage.validMany(record);
    }
}
