package org.xiao.ns.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ArrayUtils;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.constant.CommonConstant;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.db.box.norm.manage.ManageService;
import org.xiao.cs.db.box.norm.manage.ManageServiceCount;
import org.xiao.ns.domain.po.Org;
import org.xiao.ns.domain.po.Route;
import org.xiao.ns.mapper.OrgDynamicSqlSupport;
import org.xiao.ns.mapper.OrgMapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class OrgManage implements ManageService<Org>, ManageServiceCount<Route, Long> {

    @Resource
    OrgMapper orgMapper;

    public String[] selectIn(String app, Long[] oidArray) {
        if (ArrayUtils.isEmpty(oidArray)) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        } else {
            SelectStatementProvider selectStatementProvider = select(OrgDynamicSqlSupport.id, OrgDynamicSqlSupport.code)
                    .from(OrgDynamicSqlSupport.org)
                    .where()
                    .and(OrgDynamicSqlSupport.valid, isEqualTo(CommonConstant.VALID_T))
                    .and(OrgDynamicSqlSupport.app, isEqualTo(app))
                    .and(OrgDynamicSqlSupport.id, isIn(oidArray))
                    .build()
                    .render(RenderingStrategies.MYBATIS3);
            return orgMapper.selectMany(selectStatementProvider).stream().map(Org::getCode).toArray(String[]::new);
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
                .and(OrgDynamicSqlSupport.pid, isEqualToWhenPresent(record.getPid()))
                .and(OrgDynamicSqlSupport.app, isEqualToWhenPresent(record.getApp()))
                .and(OrgDynamicSqlSupport.code, isEqualToWhenPresent(record.getCode()))
                .and(OrgDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public List<Org> selectLazy(Org record) {
        return orgMapper.select(route -> route
                .where(OrgDynamicSqlSupport.org.column("0"), isEqualTo("0"))
                .and(OrgDynamicSqlSupport.app, isEqualToWhenPresent(record.getApp()))
                .and(OrgDynamicSqlSupport.pid, isEqualToWhenPresent(record.getId()))
                .and(OrgDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public PageInfo<Org> selectPage(Org record, int pageNum, int pageSize) {
        try (Page<Org> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPageInfo(() -> selectMany(record));
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
                .set(OrgDynamicSqlSupport.valid).equalTo(valid)
                .where()
                .and(OrgDynamicSqlSupport.pid, isEqualTo(parentId)));

        List<Org> children = orgMapper.select(menu -> menu
                .where(OrgDynamicSqlSupport.pid, isEqualToWhenPresent(parentId)));

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

    @Override
    public long countByKey(Long record) {
        return orgMapper.count(route -> route.where(OrgDynamicSqlSupport.pid, isEqualTo(record)));
    }
}
