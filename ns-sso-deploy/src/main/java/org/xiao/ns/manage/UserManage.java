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
public class UserManage implements ManageService<User> {

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteOne(Long record) {
        return userMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return userMapper.delete(api -> api
                .where()
                .and(UserDynamicSqlSupport.id, isIn(record)));
    }

    @Override
    public int insertOne(User record) {
        record.setPassword(EncoderUtils.encode(record.getPassword()));
        return userMapper.insertSelective(record);
    }

    @Override
    public int insertMany(List<User> record) {
        return userMapper.insertMultiple(record);
    }

    @Override
    public User selectOne(Long record) {
        return userMapper.selectOne(api -> api
                        .where()
                        .and(UserDynamicSqlSupport.id, isEqualTo(record)))
                .orElse(null);
    }

    @Override
    public List<User> selectMany(User record) {
        return userMapper.select(member -> member
                .where(UserDynamicSqlSupport.user.column("0"), isEqualTo("0"))
                .and(UserDynamicSqlSupport.username, isEqualToWhenPresent(record.getUsername()))
                .and(UserDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public PageInfo<User> selectPage(User record, int pageNum, int pageSize) {
        try (Page<User> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPageInfo(() -> selectMany(record));
        }
    }

    @Override
    public int updateOne(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMany(List<User> record) {
        AtomicInteger count = new AtomicInteger();
        record.forEach(item -> {
            if (userMapper.updateByPrimaryKeySelective(item) > 0) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return userMapper.update(api -> api
                .set(UserDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(UserDynamicSqlSupport.id, isEqualTo(record.getBy())));
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return userMapper.update(api -> api
                .set(UserDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(UserDynamicSqlSupport.id, isIn(record.getBy())));
    }
}
