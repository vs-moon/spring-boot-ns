package org.xiao.ns.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.constant.CommonConstant;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.db.box.norm.manage.ManageService;
import org.xiao.cs.db.box.norm.manage.ManageServiceCount;
import org.xiao.ns.domain.po.Menu;
import org.xiao.ns.mapper.MenuDynamicSqlSupport;
import org.xiao.ns.mapper.MenuMapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class MenuManage implements ManageService<Menu>, ManageServiceCount<Menu, Long> {

    @Resource
    MenuMapper menuMapper;

    public List<Menu> selectIn(String source, Long[] menuIdArray) {
        return menuMapper.select(menu -> menu
                        .where()
                        .and(MenuDynamicSqlSupport.source, isEqualTo(source))
                        .and(MenuDynamicSqlSupport.valid, isEqualTo(CommonConstant.VALID_T))
                        .and(MenuDynamicSqlSupport.id, isIn(menuIdArray)));
    }

    @Override
    public int deleteOne(Long record) {
        return menuMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return menuMapper.delete(api -> api
                .where()
                .and(MenuDynamicSqlSupport.id, isIn(record)));
    }

    @Override
    public int insertOne(Menu record) {
        return menuMapper.insertSelective(record);
    }

    @Override
    public int insertMany(List<Menu> record) {
        return menuMapper.insertMultiple(record);
    }

    @Override
    public Menu selectOne(Long record) {
        return menuMapper.selectOne(api -> api
                        .where()
                        .and(MenuDynamicSqlSupport.id, isEqualTo(record)))
                .orElse(null);
    }

    @Override
    public List<Menu> selectMany(Menu record) {
        return menuMapper.select(menu -> menu
                .where(MenuDynamicSqlSupport.menu.column("0"), isEqualTo("0"))
                .and(MenuDynamicSqlSupport.source, isEqualToWhenPresent(record.getSource()))
                .and(MenuDynamicSqlSupport.parentId, isEqualToWhenPresent(record.getParentId()))
                .and(MenuDynamicSqlSupport.menuName, isEqualToWhenPresent(record.getMenuName()))
                .and(MenuDynamicSqlSupport.routeName, isEqualToWhenPresent(record.getRouteName()))
                .and(MenuDynamicSqlSupport.routePath, isEqualToWhenPresent(record.getRoutePath()))
                .and(MenuDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public PageInfo<Menu> selectPage(Menu record, int pageNum, int pageSize) {
        try (Page<Menu> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPageInfo(() -> selectMany(record));
        }
    }

    @Override
    public int updateOne(Menu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMany(List<Menu> record) {
        AtomicInteger count = new AtomicInteger();
        record.forEach(item -> {
            if (menuMapper.updateByPrimaryKeySelective(item) > 0) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        int count = menuMapper.update(api -> api
                .set(MenuDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(MenuDynamicSqlSupport.id, isEqualTo(record.getBy())));

        return validRecursion(record.getBy(), record.getTo(), count);
    }

    public Integer validRecursion (Long parentId, String valid, Integer count) {

        count += menuMapper.update(api -> api
                .set(MenuDynamicSqlSupport.valid).equalTo(valid)
                .where()
                .and(MenuDynamicSqlSupport.parentId, isEqualTo(parentId)));

        List<Menu> children = menuMapper.select(menu -> menu
                .where(MenuDynamicSqlSupport.parentId, isEqualToWhenPresent(parentId)));

        if (children != null && !children.isEmpty()) {
            for (Menu item : children) {
                count = validRecursion(item.getId(), valid, count);
            }
        }

        return count;
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return menuMapper.update(api -> api
                .set(MenuDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(MenuDynamicSqlSupport.id, isIn(record.getBy())));
    }

    @Override
    public long countByKey(Long record) {
        return menuMapper.count(menu -> menu.where(MenuDynamicSqlSupport.parentId, isEqualTo(record)));
    }
}
