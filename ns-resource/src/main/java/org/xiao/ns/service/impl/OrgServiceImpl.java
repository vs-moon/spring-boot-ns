package org.xiao.ns.service.impl;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.ns.domain.po.Org;
import org.xiao.ns.manage.OrgManage;
import org.xiao.ns.service.OrgService;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

    @Resource
    OrgManage orgManage;

    @Override
    public List<Org> selectIn(String source, Long[] roleIdArray) {
        return orgManage.selectIn(source, roleIdArray);
    }

    @Override
    public int deleteOne(Long record) {
        return orgManage.deleteOne(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return orgManage.deleteMany(record);
    }

    @Override
    public int insertOne(Org record) {
        return orgManage.insertOne(record);
    }

    @Override
    public int insertMany(List<Org> record) {
        return orgManage.insertMany(record);
    }

    @Override
    public Org selectOne(Long record) {
        return orgManage.selectOne(record);
    }

    @Override
    public List<? extends Org> selectMany(Org record) {
        return orgManage.selectMany(record);
    }

    @Override
    public PageInfo<? extends Org> selectPage(Org record, int pageNum, int pageSize) {
        return orgManage.selectPage(record, pageNum, pageSize);
    }

    @Override
    public int updateOne(Org record) {
        return orgManage.updateOne(record);
    }

    @Override
    public int updateMany(List<Org> record) {
        return orgManage.updateMany(record);
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return orgManage.validOne(record);
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return orgManage.validMany(record);
    }
}
