package org.xiao.ns.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ArrayUtils;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.constant.CommonConstant;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.db.box.norm.manage.ManageService;
import org.xiao.ns.domain.po.Permission;
import org.xiao.ns.mapper.PermissionDynamicSqlSupport;
import org.xiao.ns.mapper.PermissionMapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class PermissionManage implements ManageService<Permission> {

    @Resource
    PermissionMapper permissionMapper;

    public String[] selectIn(String source, Long[] orgIdArray, Long[] roleIdArray) {

        QueryExpressionDSL<org.mybatis.dynamic.sql.select.SelectModel>.QueryExpressionWhereBuilder andQuery = selectDistinct(PermissionDynamicSqlSupport.code)
                .from(PermissionDynamicSqlSupport.permission)
                .where()
                .and(PermissionDynamicSqlSupport.valid, isEqualTo(CommonConstant.VALID_T))
                .and(PermissionDynamicSqlSupport.source, isEqualTo(source));

        if (ArrayUtils.isEmpty(orgIdArray) && ArrayUtils.isEmpty(roleIdArray)) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        } else if (ArrayUtils.isNotEmpty(orgIdArray) && ArrayUtils.isNotEmpty(roleIdArray)) {
            andQuery
                    .and(PermissionDynamicSqlSupport.id, isInWhenPresent(orgIdArray),
                            or(PermissionDynamicSqlSupport.id, isInWhenPresent(roleIdArray)));
        } else if (ArrayUtils.isNotEmpty(orgIdArray)) {
            andQuery
                    .and(PermissionDynamicSqlSupport.id, isInWhenPresent(orgIdArray));
        } else {
            andQuery
                    .and(PermissionDynamicSqlSupport.id, isInWhenPresent(roleIdArray));
        }

        SelectStatementProvider selectStatementProvider = andQuery
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return permissionMapper.selectMany(selectStatementProvider).stream().map(Permission::getCode).toArray(String[]::new);
    }

    @Override
    public int deleteOne(Long record) {
        return permissionMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return permissionMapper.delete(api -> api
                .where()
                .and(PermissionDynamicSqlSupport.id, isIn(record)));
    }

    @Override
    public int insertOne(Permission record) {
        return permissionMapper.insertSelective(record);
    }

    @Override
    public int insertMany(List<Permission> record) {
        return permissionMapper.insertMultiple(record);
    }

    @Override
    public Permission selectOne(Long record) {
        return permissionMapper.selectOne(api -> api
                        .where()
                        .and(PermissionDynamicSqlSupport.id, isEqualTo(record)))
                .orElse(null);
    }

    @Override
    public List<Permission> selectMany(Permission record) {
        return permissionMapper.select(permission -> permission
                .where(PermissionDynamicSqlSupport.permission.column("0"), isEqualTo("0"))
                .and(PermissionDynamicSqlSupport.source, isEqualToWhenPresent(record.getSource()))
                .and(PermissionDynamicSqlSupport.code, isEqualToWhenPresent(record.getCode()))
                .and(PermissionDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public PageInfo<Permission> selectPage(Permission record, int pageNum, int pageSize) {
        try (Page<Permission> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPageInfo(() -> selectMany(record));
        }
    }

    @Override
    public int updateOne(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMany(List<Permission> record) {
        AtomicInteger count = new AtomicInteger();
        record.forEach(item -> {
            if (permissionMapper.updateByPrimaryKeySelective(item) > 0) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return permissionMapper.update(api -> api
                .set(PermissionDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(PermissionDynamicSqlSupport.id, isEqualTo(record.getBy())));
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return permissionMapper.update(api -> api
                .set(PermissionDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(PermissionDynamicSqlSupport.id, isIn(record.getBy())));
    }
}
