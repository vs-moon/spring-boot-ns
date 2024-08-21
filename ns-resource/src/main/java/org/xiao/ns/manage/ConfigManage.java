package org.xiao.ns.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.db.box.norm.manage.ManageService;
import org.xiao.ns.domain.po.Config;
import org.xiao.ns.mapper.ConfigDynamicSqlSupport;
import org.xiao.ns.mapper.ConfigMapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class ConfigManage implements ManageService<Config> {

    @Resource
    ConfigMapper configMapper;

    @Override
    public int deleteOne(Long record) {
        return configMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return configMapper.delete(config -> config
                .where()
                .and(ConfigDynamicSqlSupport.id, isIn(record)));
    }

    @Override
    public int insertOne(Config record) {
        return configMapper.insertSelective(record);
    }

    @Override
    public int insertMany(List<Config> record) {
        return configMapper.insertMultiple(record);
    }

    @Override
    public Config selectOne(Long record) {
        return configMapper.selectOne(config -> config
                .where()
                .and(ConfigDynamicSqlSupport.id, isEqualTo(record)))
                .orElse(null);
    }

    @Override
    public List<Config> selectMany(Config record) {
        return configMapper.select(config -> config
                .where(ConfigDynamicSqlSupport.config.column("0"), isEqualTo("0"))
                .and(ConfigDynamicSqlSupport.app, isEqualToWhenPresent(record.getApp()))
                .and(ConfigDynamicSqlSupport.dataType, isEqualToWhenPresent(record.getDataType()))
                .and(ConfigDynamicSqlSupport.attributeName, isLikeCaseInsensitiveWhenPresent(record.getAttributeName()))
                .and(ConfigDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public PageInfo<Config> selectPage(Config record, int pageNum, int pageSize) {
        try (Page<Config> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPageInfo(() -> selectMany(record));
        }
    }

    @Override
    public int updateOne(Config record) {
        return configMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMany(List<Config> record) {
        AtomicInteger count = new AtomicInteger();
        record.forEach(item -> {
            if (configMapper.updateByPrimaryKeySelective(item) > 0) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return configMapper.update(config -> config
                .set(ConfigDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(ConfigDynamicSqlSupport.id, isEqualTo(record.getBy())));
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return configMapper.update(config -> config
                .set(ConfigDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(ConfigDynamicSqlSupport.id, isIn(record.getBy())));
    }
}
