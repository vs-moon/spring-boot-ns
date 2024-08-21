package org.xiao.ns.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.db.box.norm.manage.ManageService;
import org.xiao.ns.domain.po.App;
import org.xiao.ns.mapper.AppDynamicSqlSupport;
import org.xiao.ns.mapper.AppMapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class AppManage implements ManageService<App> {

    @Resource
    AppMapper appMapper;

    @Override
    public int deleteOne(Long record) {
        return appMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return appMapper.delete(app -> app
                .where()
                .and(AppDynamicSqlSupport.id, isIn(record)));
    }

    @Override
    public int insertOne(App record) {
        return appMapper.insertSelective(record);
    }

    @Override
    public int insertMany(List<App> record) {
        return appMapper.insertMultiple(record);
    }

    @Override
    public App selectOne(Long record) {
        return appMapper.selectOne(app -> app
                .where()
                .and(AppDynamicSqlSupport.id, isEqualTo(record)))
                .orElse(null);
    }

    @Override
    public List<App> selectMany(App record) {
        return appMapper.select(app -> app
                .where(AppDynamicSqlSupport.app.column("0"), isEqualTo("0"))
                .and(AppDynamicSqlSupport.code, isEqualToWhenPresent(record.getCode()))
                .and(AppDynamicSqlSupport.name, isLikeCaseInsensitiveWhenPresent(record.getName()))
                .and(AppDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public PageInfo<App> selectPage(App record, int pageNum, int pageSize) {
        try (Page<App> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPageInfo(() -> selectMany(record));
        }
    }

    @Override
    public int updateOne(App record) {
        return appMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMany(List<App> record) {
        AtomicInteger count = new AtomicInteger();
        record.forEach(item -> {
            if (appMapper.updateByPrimaryKeySelective(item) > 0) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return appMapper.update(app -> app
                .set(AppDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(AppDynamicSqlSupport.id, isEqualTo(record.getBy())));
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return appMapper.update(app -> app
                .set(AppDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(AppDynamicSqlSupport.id, isIn(record.getBy())));
    }
}
