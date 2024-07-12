package org.xiao.ns.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ArrayUtils;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.constant.CommonConstant;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.db.box.service.business.BusinessService;
import org.xiao.ns.domain.po.Org;
import org.xiao.ns.mapper.MenuDynamicSqlSupport;
import org.xiao.ns.mapper.OrgDynamicSqlSupport;
import org.xiao.ns.mapper.OrgMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class OrgManage implements BusinessService<Org> {

    @Resource
    OrgMapper orgMapper;

    public List<Org> selectIn(String source, Long[] orgIdArray) {
        if (ArrayUtils.isEmpty(orgIdArray)) {
            return new ArrayList<>();
        } else {
            SelectStatementProvider selectStatementProvider = select(OrgDynamicSqlSupport.id, OrgDynamicSqlSupport.code)
                    .from(OrgDynamicSqlSupport.org)
                    .where()
                    .and(OrgDynamicSqlSupport.valid, isEqualTo(CommonConstant.VALID_T))
                    .and(OrgDynamicSqlSupport.source, isEqualTo(source))
                    .and(OrgDynamicSqlSupport.id, isInWhenPresent(orgIdArray))
                    .build()
                    .render(RenderingStrategies.MYBATIS3);
            return orgMapper.selectMany(selectStatementProvider);
        }
    }

    @Override
    public int deleteOne(Long record) {
        return orgMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return orgMapper.delete(api -> api
                .where()
                .and(OrgDynamicSqlSupport.id, isIn(record)));
    }

    @Override
    public int insertOne(Org record) {
        return orgMapper.insertSelective(record);
    }

    @Override
    public int insertMany(List<Org> record) {
        return orgMapper.insertMultiple(record);
    }

    @Override
    public Org selectOne(Long record) {
        return orgMapper.selectOne(api -> api
                        .where()
                        .and(OrgDynamicSqlSupport.id, isEqualTo(record)))
                .orElse(null);
    }

    @Override
    public List<Org> selectMany(Org record) {
        return orgMapper.select(org -> org
                .where(OrgDynamicSqlSupport.org.column("0"), isEqualTo("0"))
                .and(OrgDynamicSqlSupport.parentId, isEqualToWhenPresent(record.getParentId()))
                .and(OrgDynamicSqlSupport.source, isEqualToWhenPresent(record.getSource()))
                .and(OrgDynamicSqlSupport.code, isEqualToWhenPresent(record.getCode()))
                .and(OrgDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public Page<Org> selectPage(Org record, int pageNum, int pageSize) {
        try (Page<Org> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPage(() -> selectMany(record));
        }
    }

    @Override
    public int updateOne(Org record) {
        return orgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMany(List<Org> record) {
        AtomicInteger count = new AtomicInteger();
        record.forEach(item -> {
            if (orgMapper.updateByPrimaryKeySelective(item) > 0) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        int count = orgMapper.update(api -> api
                .set(OrgDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(OrgDynamicSqlSupport.id, isEqualTo(record.getBy())));

        return validRecursion(record.getBy(), record.getTo(), count);
    }

    public Integer validRecursion (Long parentId, String valid, Integer count) {

        count += orgMapper.update(api -> api
                .set(MenuDynamicSqlSupport.valid).equalTo(valid)
                .where()
                .and(MenuDynamicSqlSupport.parentId, isEqualTo(parentId)));

        List<Org> children = orgMapper.select(menu -> menu
                .where(MenuDynamicSqlSupport.parentId, isEqualToWhenPresent(parentId)));

        if (children != null && !children.isEmpty()) {
            for (Org item : children) {
                count = validRecursion(item.getId(), valid, count);
            }
        }

        return count;
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return orgMapper.update(api -> api
                .set(OrgDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(OrgDynamicSqlSupport.id, isIn(record.getBy())));
    }
}
