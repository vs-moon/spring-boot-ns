package org.xiao.ns.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.db.box.norm.manage.ManageService;
import org.xiao.cs.sso.box.utils.EncoderUtils;
import org.xiao.ns.domain.po.*;
import org.xiao.ns.mapper.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;

@Service
public class MemberManage implements ManageService<Member> {
    @Resource
    private MemberMapper memberMapper;

    @Override
    public int deleteOne(Long record) {
        return memberMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return memberMapper.delete(api -> api
                .where()
                .and(MemberDynamicSqlSupport.id, isIn(record)));
    }

    @Override
    public int insertOne(Member record) {
        record.setPassword(EncoderUtils.encode(record.getPassword()));
        return memberMapper.insertSelective(record);
    }

    @Override
    public int insertMany(List<Member> record) {
        return memberMapper.insertMultiple(record);
    }

    @Override
    public Member selectOne(Long record) {
        return memberMapper.selectOne(api -> api
                        .where()
                        .and(MemberDynamicSqlSupport.id, isEqualTo(record)))
                .orElse(null);
    }

    @Override
    public List<Member> selectMany(Member record) {
        return memberMapper.select(member -> member
                .where(MemberDynamicSqlSupport.member.column("0"), isEqualTo("0"))
                .and(MemberDynamicSqlSupport.username, isEqualToWhenPresent(record.getUsername()))
                .and(MemberDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public PageInfo<Member> selectPage(Member record, int pageNum, int pageSize) {
        try (Page<Member> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPageInfo(() -> selectMany(record));
        }
    }

    @Override
    public int updateOne(Member record) {
        return memberMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMany(List<Member> record) {
        AtomicInteger count = new AtomicInteger();
        record.forEach(item -> {
            if (memberMapper.updateByPrimaryKeySelective(item) > 0) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return memberMapper.update(api -> api
                .set(MemberDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(MemberDynamicSqlSupport.id, isEqualTo(record.getBy())));
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return memberMapper.update(api -> api
                .set(MemberDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(MemberDynamicSqlSupport.id, isIn(record.getBy())));
    }
}
