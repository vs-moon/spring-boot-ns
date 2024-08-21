package org.xiao.ns.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.db.box.norm.manage.ManageService;
import org.xiao.ns.domain.po.DicType;
import org.xiao.ns.mapper.DicTypeDynamicSqlSupport;
import org.xiao.ns.mapper.DicTypeMapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class DicTypeManage implements ManageService<DicType> {

    @Resource
    DicTypeMapper dicTypeMapper;

    public int deleteOne(Long record) {
        return dicTypeMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return dicTypeMapper.delete(api -> api
                .where()
                .and(DicTypeDynamicSqlSupport.id, isInWhenPresent(record)));
    }

    @Override
    public int insertOne(DicType record) {
        return dicTypeMapper.insertSelective(record);
    }

    @Override
    public int insertMany(List<DicType> record) {
        return dicTypeMapper.insertMultiple(record);
    }

    @Override
    public DicType selectOne(Long record) {
        return dicTypeMapper.selectOne(dic -> dic
                        .where()
                        .and(DicTypeDynamicSqlSupport.id, isEqualToWhenPresent(record)))
                .orElse(null);
    }

    @Override
    public List<DicType> selectMany(DicType record) {
        return dicTypeMapper.select(dic -> dic
                .where(DicTypeDynamicSqlSupport.dicType.column("0"), isEqualTo("0"))
                .and(DicTypeDynamicSqlSupport.code, isEqualToWhenPresent(record.getCode()))
                .and(DicTypeDynamicSqlSupport.name, isEqualToWhenPresent(record.getName()))
                .and(DicTypeDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public PageInfo<DicType> selectPage(DicType record, int pageNum, int pageSize) {
        try (Page<DicType> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPageInfo(() -> selectMany(record));
        }
    }

    @Override
    public int updateOne(DicType record) {
        return dicTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMany(List<DicType> record) {
        AtomicInteger count = new AtomicInteger();
        record.forEach(item -> {
            if (dicTypeMapper.updateByPrimaryKeySelective(item) > 0) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return dicTypeMapper.update(api -> api
                .set(DicTypeDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(DicTypeDynamicSqlSupport.id, isEqualTo(record.getBy())));
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return dicTypeMapper.update(api -> api
                .set(DicTypeDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(DicTypeDynamicSqlSupport.id, isIn(record.getBy())));
    }
}
