package org.xiao.ns.service.impl;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.ns.domain.po.Member;
import org.xiao.ns.manage.MemberManage;
import org.xiao.ns.service.MemberService;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    MemberManage memberManage;

    @Override
    public int deleteOne(Long record) {
        return memberManage.deleteOne(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return memberManage.deleteMany(record);
    }

    @Override
    public int insertOne(Member record) {
        return memberManage.insertOne(record);
    }

    @Override
    public int insertMany(List<Member> record) {
        return memberManage.insertMany(record);
    }

    @Override
    public Member selectOne(Long record) {
        return memberManage.selectOne(record);
    }

    @Override
    public List<? extends Member> selectMany(Member record) {
        return memberManage.selectMany(record);
    }

    @Override
    public PageInfo<? extends Member> selectPage(Member record, int pageNum, int pageSize) {
        return memberManage.selectPage(record, pageNum, pageSize);
    }

    @Override
    public int updateOne(Member record) {
        return memberManage.updateOne(record);
    }

    @Override
    public int updateMany(List<Member> record) {
        return memberManage.updateMany(record);
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return memberManage.validOne(record);
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return memberManage.validMany(record);
    }
}
