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
import org.xiao.ns.domain.po.Role;
import org.xiao.ns.mapper.MenuDynamicSqlSupport;
import org.xiao.ns.mapper.RoleDynamicSqlSupport;
import org.xiao.ns.mapper.RoleMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class RoleManage implements BusinessService<Role> {

    @Resource
    RoleMapper roleMapper;

    public List<Role> selectIn(String source, Long[] roleIdArray) {
        if (ArrayUtils.isEmpty(roleIdArray)) {
            return new ArrayList<>();
        } else {
            SelectStatementProvider selectStatementProvider = select(RoleDynamicSqlSupport.id, RoleDynamicSqlSupport.code)
                    .from(RoleDynamicSqlSupport.role)
                    .where()
                    .and(RoleDynamicSqlSupport.valid, isEqualTo(CommonConstant.VALID_T))
                    .and(RoleDynamicSqlSupport.source, isEqualTo(source))
                    .and(RoleDynamicSqlSupport.id, isInWhenPresent(roleIdArray))
                    .build()
                    .render(RenderingStrategies.MYBATIS3);
            return roleMapper.selectMany(selectStatementProvider);
        }
    }

    @Override
    public int deleteOne(Long record) {
        return roleMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return roleMapper.delete(api -> api
                .where()
                .and(RoleDynamicSqlSupport.id, isIn(record)));
    }

    @Override
    public int insertOne(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public int insertMany(List<Role> record) {
        return roleMapper.insertMultiple(record);
    }

    @Override
    public Role selectOne(Long record) {
        return roleMapper.selectOne(api -> api
                        .where()
                        .and(RoleDynamicSqlSupport.id, isEqualTo(record)))
                .orElse(null);
    }

    @Override
    public List<Role> selectMany(Role record) {
        return roleMapper.select(role -> role
                .where(RoleDynamicSqlSupport.role.column("0"), isEqualTo("0"))
                .and(RoleDynamicSqlSupport.source, isEqualToWhenPresent(record.getSource()))
                .and(RoleDynamicSqlSupport.parentId, isEqualToWhenPresent(record.getParentId()))
                .and(RoleDynamicSqlSupport.code, isEqualToWhenPresent(record.getCode()))
                .and(RoleDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public Page<Role> selectPage(Role record, int pageNum, int pageSize) {
        try (Page<Role> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPage(() -> selectMany(record));
        }
    }

    @Override
    public int updateOne(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMany(List<Role> record) {
        AtomicInteger count = new AtomicInteger();
        record.forEach(item -> {
            if (roleMapper.updateByPrimaryKeySelective(item) > 0) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        int count = roleMapper.update(api -> api
                .set(RoleDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(RoleDynamicSqlSupport.id, isEqualTo(record.getBy())));

        return validRecursion(record.getBy(), record.getTo(), count);
    }

    public Integer validRecursion (Long parentId, String valid, Integer count) {

        count += roleMapper.update(api -> api
                .set(MenuDynamicSqlSupport.valid).equalTo(valid)
                .where()
                .and(MenuDynamicSqlSupport.parentId, isEqualTo(parentId)));

        List<Role> children = roleMapper.select(menu -> menu
                .where(MenuDynamicSqlSupport.parentId, isEqualToWhenPresent(parentId)));

        if (children != null && !children.isEmpty()) {
            for (Role item : children) {
                count = validRecursion(item.getId(), valid, count);
            }
        }

        return count;
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return roleMapper.update(api -> api
                .set(RoleDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(RoleDynamicSqlSupport.id, isIn(record.getBy())));
    }
}
