package org.xiao.ns.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.constant.CommonConstant;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.db.box.norm.manage.ManageService;
import org.xiao.cs.db.box.norm.manage.ManageServiceCount;
import org.xiao.cs.properties.box.SymbolProperties;
import org.xiao.cs.sso.box.utils.TokenUtils;
import org.xiao.ns.domain.po.Route;
import org.xiao.ns.mapper.RouteDynamicSqlSupport;
import org.xiao.ns.mapper.RouteMapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class RouteManage implements ManageService<Route>, ManageServiceCount<Route, Long> {

    @Resource
    RouteMapper routeMapper;

    @Resource
    TokenUtils tokenUtils;
    @Resource
    SymbolProperties symbolProperties;

    public List<Route> selectIn(String app, Long[] routeIdArray) {
        String permission = tokenUtils.toBean().getPermission();

        return routeMapper.select(route -> {
            QueryExpressionDSL<org.mybatis.dynamic.sql.select.SelectModel>.QueryExpressionWhereBuilder where = route.where();


            where.and(RouteDynamicSqlSupport.app, isEqualTo(app));
            where.and(RouteDynamicSqlSupport.valid, isEqualTo(CommonConstant.VALID_T));

            if (!permission.contains(symbolProperties.getTopPermissions())) {
                where.and(RouteDynamicSqlSupport.id, isIn(routeIdArray));
            }

            return route;
        });
    }

    @Override
    public int deleteOne(Long record) {
        return routeMapper.deleteByPrimaryKey(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return routeMapper.delete(api -> api
                .where()
                .and(RouteDynamicSqlSupport.id, isIn(record)));
    }

    @Override
    public int insertOne(Route record) {
        return routeMapper.insertSelective(record);
    }

    @Override
    public int insertMany(List<Route> record) {
        return routeMapper.insertMultiple(record);
    }

    @Override
    public Route selectOne(Long record) {
        return routeMapper.selectOne(api -> api
                        .where()
                        .and(RouteDynamicSqlSupport.id, isEqualTo(record)))
                .orElse(null);
    }

    @Override
    public List<Route> selectMany(Route record) {
        return routeMapper.select(route -> route
                .where(RouteDynamicSqlSupport.route.column("0"), isEqualTo("0"))
                .and(RouteDynamicSqlSupport.app, isEqualToWhenPresent(record.getApp()))
                .and(RouteDynamicSqlSupport.pid, isEqualToWhenPresent(record.getPid()))
                .and(RouteDynamicSqlSupport.title, isEqualToWhenPresent(record.getTitle()))
                .and(RouteDynamicSqlSupport.name, isEqualToWhenPresent(record.getName()))
                .and(RouteDynamicSqlSupport.path, isEqualToWhenPresent(record.getPath()))
                .and(RouteDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public List<Route> selectLazy(Route record) {
        return routeMapper.select(route -> route
                .where(RouteDynamicSqlSupport.route.column("0"), isEqualTo("0"))
                .and(RouteDynamicSqlSupport.app, isEqualToWhenPresent(record.getApp()))
                .and(RouteDynamicSqlSupport.pid, isEqualToWhenPresent(record.getId()))
                .and(RouteDynamicSqlSupport.valid, isEqualToWhenPresent(record.getValid())));
    }

    @Override
    public PageInfo<Route> selectPage(Route record, int pageNum, int pageSize) {
        try (Page<Route> page = PageHelper.startPage(pageNum, pageSize)) {
            return page.doSelectPageInfo(() -> selectMany(record));
        }
    }

    @Override
    public int updateOne(Route record) {
        return routeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateMany(List<Route> record) {
        AtomicInteger count = new AtomicInteger();
        record.forEach(item -> {
            if (routeMapper.updateByPrimaryKeySelective(item) > 0) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        int count = routeMapper.update(api -> api
                .set(RouteDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(RouteDynamicSqlSupport.id, isEqualTo(record.getBy())));

        return validRecursion(record.getBy(), record.getTo(), count);
    }

    public Integer validRecursion (Long parentId, String valid, Integer count) {

        count += routeMapper.update(api -> api
                .set(RouteDynamicSqlSupport.valid).equalTo(valid)
                .where()
                .and(RouteDynamicSqlSupport.pid, isEqualTo(parentId)));

        List<Route> children = routeMapper.select(route -> route
                .where(RouteDynamicSqlSupport.pid, isEqualToWhenPresent(parentId)));

        if (children != null && !children.isEmpty()) {
            for (Route item : children) {
                count = validRecursion(item.getId(), valid, count);
            }
        }

        return count;
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return routeMapper.update(api -> api
                .set(RouteDynamicSqlSupport.valid).equalTo(record.getTo())
                .where()
                .and(RouteDynamicSqlSupport.id, isIn(record.getBy())));
    }

    @Override
    public long countByKey(Long record) {
        return routeMapper.count(route -> route.where(RouteDynamicSqlSupport.pid, isEqualTo(record)));
    }
}
