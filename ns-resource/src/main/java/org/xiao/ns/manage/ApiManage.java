package org.xiao.ns.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.db.box.norm.manage.ManageService;
import org.xiao.ns.domain.po.Api;
import org.xiao.ns.mapper.ApiDynamicSqlSupport;
import org.xiao.ns.mapper.ApiMapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class ApiManage implements ManageService<Api> {

    @Resource
    ApiMapper apiMapper;

    @Override
    public int deleteOne(Long record) {
        return apiMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return apiMapper.delete(api -> api
                .where()
                .and(ApiDynamicSqlSupport.id, isIn(record)));
    }

    @Override
    public int insertOne(Api record) {
        return apiMapper.insertSelective(record);
    }

    @Override
    public int insertMany(List<Api> record) {
        return apiMapper.insertMultiple(record);
    }

    @Override
    public Api selectOne(Long record) {
        return apiMapper.selectOne(api -> api
                .where()
                .and(ApiDynamicSqlSupport.id, isEqualTo(record)))
                .orElse(null);
    }

    @Override
    public List<Api> selectMany(Api record) {
        return apiMapper.select(api -> api
                .where(ApiDynamicSqlSupport.api.column("0"), isEqualTo("0"))
                .and(ApiDynamicSqlSupport.app, isEqualToWhenPresent(record.getApp()))
                .and(ApiDynamicSqlSupport.method, isEqualToWhenPresent(record.getMethod()))
                .and(ApiDynamicSqlSupport.path, isLikeCaseInsensitiveWhenPresent(record.getPath()))
                .and(ApiDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public PageInfo<Api> selectPage(Api record, int pageNum, int pageSize) {
        try (Page<Api> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPageInfo(() -> selectMany(record));
        }
    }

    @Override
    public int updateOne(Api record) {
        return apiMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMany(List<Api> record) {
        AtomicInteger count = new AtomicInteger();
        record.forEach(item -> {
            if (apiMapper.updateByPrimaryKeySelective(item) > 0) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return apiMapper.update(api -> api
                .set(ApiDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(ApiDynamicSqlSupport.id, isEqualTo(record.getBy())));
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return apiMapper.update(api -> api
                .set(ApiDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(ApiDynamicSqlSupport.id, isIn(record.getBy())));
    }
}
