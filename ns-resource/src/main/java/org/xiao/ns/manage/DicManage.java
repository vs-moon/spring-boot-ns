package org.xiao.ns.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.db.box.service.business.BusinessService;
import org.xiao.ns.domain.po.Dic;
import org.xiao.ns.mapper.DicDynamicSqlSupport;
import org.xiao.ns.mapper.DicMapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class DicManage implements BusinessService<Dic> {

    @Resource
    DicMapper dicMapper;

    @Override
    public int deleteOne(Long record) {
        return dicMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return dicMapper.delete(api -> api
                .where()
                .and(DicDynamicSqlSupport.id, isInWhenPresent(record)));
    }

    @Override
    public int insertOne(Dic record) {
        return dicMapper.insertSelective(record);
    }

    @Override
    public int insertMany(List<Dic> record) {
        return dicMapper.insertMultiple(record);
    }

    @Override
    public Dic selectOne(Long record) {
        return dicMapper.selectOne(dic -> dic
                .where()
                .and(DicDynamicSqlSupport.id, isEqualToWhenPresent(record)))
                .orElse(null);
    }

    @Override
    public List<Dic> selectMany(Dic record) {
        return dicMapper.select(dic -> dic
                .where(DicDynamicSqlSupport.dic.column("0"), isEqualTo("0"))
                .and(DicDynamicSqlSupport.type, isEqualToWhenPresent(record.getType()))
                .and(DicDynamicSqlSupport.code, isEqualToWhenPresent(record.getCode()))
                .and(DicDynamicSqlSupport.fixed, isEqualToWhenPresent(record.getFixed()))
                .and(DicDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public Page<Dic> selectPage(Dic record, int pageNum, int pageSize) {
        try (Page<Dic> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPage(() -> selectMany(record));
        }
    }

    @Override
    public int updateOne(Dic record) {
        return dicMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMany(List<Dic> record) {
        AtomicInteger count = new AtomicInteger();
        record.forEach(item -> {
            if (dicMapper.updateByPrimaryKeySelective(item) > 0) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return dicMapper.update(api -> api
                .set(DicDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(DicDynamicSqlSupport.id, isEqualTo(record.getBy())));
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return dicMapper.update(api -> api
                .set(DicDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(DicDynamicSqlSupport.id, isIn(record.getBy())));
    }
}
