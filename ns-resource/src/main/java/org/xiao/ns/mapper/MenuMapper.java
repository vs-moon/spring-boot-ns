package org.xiao.ns.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.xiao.ns.mapper.MenuDynamicSqlSupport.*;

import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.xiao.ns.domain.po.Menu;

@Mapper
public interface MenuMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Menu>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, parentId, source, modulePath, jumpMode, routePath, routeName, routeAlive, menuMode, menuName, menuIcon, sort, createBy, createTime, updateBy, updateTime, valid);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MenuResult", value = {
        @Result(column="F_ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="F_PARENT_ID", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="F_SOURCE", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_MODULE_PATH", property="modulePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_JUMP_MODE", property="jumpMode", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_ROUTE_PATH", property="routePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_ROUTE_NAME", property="routeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_ROUTE_ALIVE", property="routeAlive", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_MENU_MODE", property="menuMode", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_MENU_NAME", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_MENU_ICON", property="menuIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="SORT", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_BY", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_BY", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="VALID", property="valid", jdbcType=JdbcType.VARCHAR)
    })
    List<Menu> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MenuResult")
    Optional<Menu> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, menu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, menu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Menu row) {
        return MyBatis3Utils.insert(this::insert, row, menu, c ->
            c.map(id).toProperty("id")
            .map(parentId).toProperty("parentId")
            .map(source).toProperty("source")
            .map(modulePath).toProperty("modulePath")
            .map(jumpMode).toProperty("jumpMode")
            .map(routePath).toProperty("routePath")
            .map(routeName).toProperty("routeName")
            .map(routeAlive).toProperty("routeAlive")
            .map(menuMode).toProperty("menuMode")
            .map(menuName).toProperty("menuName")
            .map(menuIcon).toProperty("menuIcon")
            .map(sort).toProperty("sort")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(valid).toProperty("valid")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Menu> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, menu, c ->
            c.map(id).toProperty("id")
            .map(parentId).toProperty("parentId")
            .map(source).toProperty("source")
            .map(modulePath).toProperty("modulePath")
            .map(jumpMode).toProperty("jumpMode")
            .map(routePath).toProperty("routePath")
            .map(routeName).toProperty("routeName")
            .map(routeAlive).toProperty("routeAlive")
            .map(menuMode).toProperty("menuMode")
            .map(menuName).toProperty("menuName")
            .map(menuIcon).toProperty("menuIcon")
            .map(sort).toProperty("sort")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(valid).toProperty("valid")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Menu row) {
        return MyBatis3Utils.insert(this::insert, row, menu, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(parentId).toPropertyWhenPresent("parentId", row::getParentId)
            .map(source).toPropertyWhenPresent("source", row::getSource)
            .map(modulePath).toPropertyWhenPresent("modulePath", row::getModulePath)
            .map(jumpMode).toPropertyWhenPresent("jumpMode", row::getJumpMode)
            .map(routePath).toPropertyWhenPresent("routePath", row::getRoutePath)
            .map(routeName).toPropertyWhenPresent("routeName", row::getRouteName)
            .map(routeAlive).toPropertyWhenPresent("routeAlive", row::getRouteAlive)
            .map(menuMode).toPropertyWhenPresent("menuMode", row::getMenuMode)
            .map(menuName).toPropertyWhenPresent("menuName", row::getMenuName)
            .map(menuIcon).toPropertyWhenPresent("menuIcon", row::getMenuIcon)
            .map(sort).toPropertyWhenPresent("sort", row::getSort)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateBy).toPropertyWhenPresent("updateBy", row::getUpdateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
            .map(valid).toPropertyWhenPresent("valid", row::getValid)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Menu> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, menu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Menu> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, menu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Menu> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, menu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Menu> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, menu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Menu row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(parentId).equalTo(row::getParentId)
                .set(source).equalTo(row::getSource)
                .set(modulePath).equalTo(row::getModulePath)
                .set(jumpMode).equalTo(row::getJumpMode)
                .set(routePath).equalTo(row::getRoutePath)
                .set(routeName).equalTo(row::getRouteName)
                .set(routeAlive).equalTo(row::getRouteAlive)
                .set(menuMode).equalTo(row::getMenuMode)
                .set(menuName).equalTo(row::getMenuName)
                .set(menuIcon).equalTo(row::getMenuIcon)
                .set(sort).equalTo(row::getSort)
                .set(createBy).equalTo(row::getCreateBy)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateBy).equalTo(row::getUpdateBy)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(valid).equalTo(row::getValid);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Menu row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(parentId).equalToWhenPresent(row::getParentId)
                .set(source).equalToWhenPresent(row::getSource)
                .set(modulePath).equalToWhenPresent(row::getModulePath)
                .set(jumpMode).equalToWhenPresent(row::getJumpMode)
                .set(routePath).equalToWhenPresent(row::getRoutePath)
                .set(routeName).equalToWhenPresent(row::getRouteName)
                .set(routeAlive).equalToWhenPresent(row::getRouteAlive)
                .set(menuMode).equalToWhenPresent(row::getMenuMode)
                .set(menuName).equalToWhenPresent(row::getMenuName)
                .set(menuIcon).equalToWhenPresent(row::getMenuIcon)
                .set(sort).equalToWhenPresent(row::getSort)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(valid).equalToWhenPresent(row::getValid);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Menu row) {
        return update(c ->
            c.set(parentId).equalTo(row::getParentId)
            .set(source).equalTo(row::getSource)
            .set(modulePath).equalTo(row::getModulePath)
            .set(jumpMode).equalTo(row::getJumpMode)
            .set(routePath).equalTo(row::getRoutePath)
            .set(routeName).equalTo(row::getRouteName)
            .set(routeAlive).equalTo(row::getRouteAlive)
            .set(menuMode).equalTo(row::getMenuMode)
            .set(menuName).equalTo(row::getMenuName)
            .set(menuIcon).equalTo(row::getMenuIcon)
            .set(sort).equalTo(row::getSort)
            .set(createBy).equalTo(row::getCreateBy)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateBy).equalTo(row::getUpdateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .set(valid).equalTo(row::getValid)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Menu row) {
        return update(c ->
            c.set(parentId).equalToWhenPresent(row::getParentId)
            .set(source).equalToWhenPresent(row::getSource)
            .set(modulePath).equalToWhenPresent(row::getModulePath)
            .set(jumpMode).equalToWhenPresent(row::getJumpMode)
            .set(routePath).equalToWhenPresent(row::getRoutePath)
            .set(routeName).equalToWhenPresent(row::getRouteName)
            .set(routeAlive).equalToWhenPresent(row::getRouteAlive)
            .set(menuMode).equalToWhenPresent(row::getMenuMode)
            .set(menuName).equalToWhenPresent(row::getMenuName)
            .set(menuIcon).equalToWhenPresent(row::getMenuIcon)
            .set(sort).equalToWhenPresent(row::getSort)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateBy).equalToWhenPresent(row::getUpdateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .set(valid).equalToWhenPresent(row::getValid)
            .where(id, isEqualTo(row::getId))
        );
    }
}