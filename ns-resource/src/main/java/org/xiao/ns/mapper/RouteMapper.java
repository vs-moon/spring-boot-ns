package org.xiao.ns.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.xiao.ns.mapper.RouteDynamicSqlSupport.*;

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
import org.xiao.ns.domain.po.Route;

@Mapper
public interface RouteMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Route>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, pid, app, uri, mode, path, name, cache, type, title, icon, linkage, home, hide, sort, createBy, createTime, updateBy, updateTime, valid, linkageConfig);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RouteResult", value = {
        @Result(column="F_ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="F_PID", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="F_APP", property="app", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_URI", property="uri", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_MODE", property="mode", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_PATH", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_CACHE", property="cache", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_TYPE", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_ICON", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_LINKAGE", property="linkage", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_HOME", property="home", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_HIDE", property="hide", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_SORT", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="CREATE_BY", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_BY", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="VALID", property="valid", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_LINKAGE_CONFIG", property="linkageConfig", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Route> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RouteResult")
    Optional<Route> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, route, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, route, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Route row) {
        return MyBatis3Utils.insert(this::insert, row, route, c ->
            c.map(id).toProperty("id")
            .map(pid).toProperty("pid")
            .map(app).toProperty("app")
            .map(uri).toProperty("uri")
            .map(mode).toProperty("mode")
            .map(path).toProperty("path")
            .map(name).toProperty("name")
            .map(cache).toProperty("cache")
            .map(type).toProperty("type")
            .map(title).toProperty("title")
            .map(icon).toProperty("icon")
            .map(linkage).toProperty("linkage")
            .map(home).toProperty("home")
            .map(hide).toProperty("hide")
            .map(sort).toProperty("sort")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(valid).toProperty("valid")
            .map(linkageConfig).toProperty("linkageConfig")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Route> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, route, c ->
            c.map(id).toProperty("id")
            .map(pid).toProperty("pid")
            .map(app).toProperty("app")
            .map(uri).toProperty("uri")
            .map(mode).toProperty("mode")
            .map(path).toProperty("path")
            .map(name).toProperty("name")
            .map(cache).toProperty("cache")
            .map(type).toProperty("type")
            .map(title).toProperty("title")
            .map(icon).toProperty("icon")
            .map(linkage).toProperty("linkage")
            .map(home).toProperty("home")
            .map(hide).toProperty("hide")
            .map(sort).toProperty("sort")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(valid).toProperty("valid")
            .map(linkageConfig).toProperty("linkageConfig")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Route row) {
        return MyBatis3Utils.insert(this::insert, row, route, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(pid).toPropertyWhenPresent("pid", row::getPid)
            .map(app).toPropertyWhenPresent("app", row::getApp)
            .map(uri).toPropertyWhenPresent("uri", row::getUri)
            .map(mode).toPropertyWhenPresent("mode", row::getMode)
            .map(path).toPropertyWhenPresent("path", row::getPath)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(cache).toPropertyWhenPresent("cache", row::getCache)
            .map(type).toPropertyWhenPresent("type", row::getType)
            .map(title).toPropertyWhenPresent("title", row::getTitle)
            .map(icon).toPropertyWhenPresent("icon", row::getIcon)
            .map(linkage).toPropertyWhenPresent("linkage", row::getLinkage)
            .map(home).toPropertyWhenPresent("home", row::getHome)
            .map(hide).toPropertyWhenPresent("hide", row::getHide)
            .map(sort).toPropertyWhenPresent("sort", row::getSort)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateBy).toPropertyWhenPresent("updateBy", row::getUpdateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
            .map(valid).toPropertyWhenPresent("valid", row::getValid)
            .map(linkageConfig).toPropertyWhenPresent("linkageConfig", row::getLinkageConfig)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Route> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, route, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Route> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, route, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Route> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, route, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Route> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, route, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Route row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(pid).equalTo(row::getPid)
                .set(app).equalTo(row::getApp)
                .set(uri).equalTo(row::getUri)
                .set(mode).equalTo(row::getMode)
                .set(path).equalTo(row::getPath)
                .set(name).equalTo(row::getName)
                .set(cache).equalTo(row::getCache)
                .set(type).equalTo(row::getType)
                .set(title).equalTo(row::getTitle)
                .set(icon).equalTo(row::getIcon)
                .set(linkage).equalTo(row::getLinkage)
                .set(home).equalTo(row::getHome)
                .set(hide).equalTo(row::getHide)
                .set(sort).equalTo(row::getSort)
                .set(createBy).equalTo(row::getCreateBy)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateBy).equalTo(row::getUpdateBy)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(valid).equalTo(row::getValid)
                .set(linkageConfig).equalTo(row::getLinkageConfig);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Route row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(pid).equalToWhenPresent(row::getPid)
                .set(app).equalToWhenPresent(row::getApp)
                .set(uri).equalToWhenPresent(row::getUri)
                .set(mode).equalToWhenPresent(row::getMode)
                .set(path).equalToWhenPresent(row::getPath)
                .set(name).equalToWhenPresent(row::getName)
                .set(cache).equalToWhenPresent(row::getCache)
                .set(type).equalToWhenPresent(row::getType)
                .set(title).equalToWhenPresent(row::getTitle)
                .set(icon).equalToWhenPresent(row::getIcon)
                .set(linkage).equalToWhenPresent(row::getLinkage)
                .set(home).equalToWhenPresent(row::getHome)
                .set(hide).equalToWhenPresent(row::getHide)
                .set(sort).equalToWhenPresent(row::getSort)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(valid).equalToWhenPresent(row::getValid)
                .set(linkageConfig).equalToWhenPresent(row::getLinkageConfig);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Route row) {
        return update(c ->
            c.set(pid).equalTo(row::getPid)
            .set(app).equalTo(row::getApp)
            .set(uri).equalTo(row::getUri)
            .set(mode).equalTo(row::getMode)
            .set(path).equalTo(row::getPath)
            .set(name).equalTo(row::getName)
            .set(cache).equalTo(row::getCache)
            .set(type).equalTo(row::getType)
            .set(title).equalTo(row::getTitle)
            .set(icon).equalTo(row::getIcon)
            .set(linkage).equalTo(row::getLinkage)
            .set(home).equalTo(row::getHome)
            .set(hide).equalTo(row::getHide)
            .set(sort).equalTo(row::getSort)
            .set(createBy).equalTo(row::getCreateBy)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateBy).equalTo(row::getUpdateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .set(valid).equalTo(row::getValid)
            .set(linkageConfig).equalTo(row::getLinkageConfig)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Route row) {
        return update(c ->
            c.set(pid).equalToWhenPresent(row::getPid)
            .set(app).equalToWhenPresent(row::getApp)
            .set(uri).equalToWhenPresent(row::getUri)
            .set(mode).equalToWhenPresent(row::getMode)
            .set(path).equalToWhenPresent(row::getPath)
            .set(name).equalToWhenPresent(row::getName)
            .set(cache).equalToWhenPresent(row::getCache)
            .set(type).equalToWhenPresent(row::getType)
            .set(title).equalToWhenPresent(row::getTitle)
            .set(icon).equalToWhenPresent(row::getIcon)
            .set(linkage).equalToWhenPresent(row::getLinkage)
            .set(home).equalToWhenPresent(row::getHome)
            .set(hide).equalToWhenPresent(row::getHide)
            .set(sort).equalToWhenPresent(row::getSort)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateBy).equalToWhenPresent(row::getUpdateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .set(valid).equalToWhenPresent(row::getValid)
            .set(linkageConfig).equalToWhenPresent(row::getLinkageConfig)
            .where(id, isEqualTo(row::getId))
        );
    }
}