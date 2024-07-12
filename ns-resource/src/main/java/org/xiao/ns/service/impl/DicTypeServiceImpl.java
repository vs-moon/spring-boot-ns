package org.xiao.ns.service.impl;

import com.github.pagehelper.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.ns.domain.po.DicType;
import org.xiao.ns.manage.DicTypeManage;
import org.xiao.ns.service.DicTypeService;

import java.util.List;

@Service
public class DicTypeServiceImpl implements DicTypeService {

    @Resource
    DicTypeManage dicTypeManage;

    @Override
    public int deleteOne(Long record) {
        return dicTypeManage.deleteOne(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return dicTypeManage.deleteMany(record);
    }

    @Override
    public int insertOne(DicType record) {
        return dicTypeManage.insertOne(record);
    }

    @Override
    public int insertMany(List<DicType> record) {
        return dicTypeManage.insertMany(record);
    }

    @Override
    public DicType selectOne(Long record) {
        return dicTypeManage.selectOne(record);
    }

    @Override
    public List<DicType> selectMany(DicType record) {
        return dicTypeManage.selectMany(record);
    }

    @Override
    public Page<DicType> selectPage(DicType record, int pageNum, int pageSize) {
        return dicTypeManage.selectPage(record, pageNum, pageSize);
    }

    @Override
    public int updateOne(DicType record) {
        return dicTypeManage.updateOne(record);
    }

    @Override
    public int updateMany(List<DicType> record) {
        return dicTypeManage.updateMany(record);
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return dicTypeManage.validOne(record);
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return dicTypeManage.validMany(record);
    }
}
