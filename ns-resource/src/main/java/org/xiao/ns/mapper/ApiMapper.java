package org.xiao.ns.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.xiao.ns.mapper.ApiDynamicSqlSupport.*;

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
import org.xiao.ns.domain.po.Api;

@Mapper
public interface ApiMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Api>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, app, path, method, createBy, createTime, updateBy, updateTime, valid);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ApiResult", value = {
        @Result(column="F_ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="F_APP", property="app", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_PATH", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_METHOD", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_BY", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_BY", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="VALID", property="valid", jdbcType=JdbcType.VARCHAR)
    })
    List<Api> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ApiResult")
    Optional<Api> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, api, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, api, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Api row) {
        return MyBatis3Utils.insert(this::insert, row, api, c ->
            c.map(id).toProperty("id")
            .map(app).toProperty("app")
            .map(path).toProperty("path")
            .map(method).toProperty("method")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(valid).toProperty("valid")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Api> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, api, c ->
            c.map(id).toProperty("id")
            .map(app).toProperty("app")
            .map(path).toProperty("path")
            .map(method).toProperty("method")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(valid).toProperty("valid")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Api row) {
        return MyBatis3Utils.insert(this::insert, row, api, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(app).toPropertyWhenPresent("app", row::getApp)
            .map(path).toPropertyWhenPresent("path", row::getPath)
            .map(method).toPropertyWhenPresent("method", row::getMethod)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateBy).toPropertyWhenPresent("updateBy", row::getUpdateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
            .map(valid).toPropertyWhenPresent("valid", row::getValid)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Api> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, api, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Api> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, api, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Api> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, api, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Api> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, api, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Api row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(app).equalTo(row::getApp)
                .set(path).equalTo(row::getPath)
                .set(method).equalTo(row::getMethod)
                .set(createBy).equalTo(row::getCreateBy)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateBy).equalTo(row::getUpdateBy)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(valid).equalTo(row::getValid);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Api row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(app).equalToWhenPresent(row::getApp)
                .set(path).equalToWhenPresent(row::getPath)
                .set(method).equalToWhenPresent(row::getMethod)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(valid).equalToWhenPresent(row::getValid);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Api row) {
        return update(c ->
            c.set(app).equalTo(row::getApp)
            .set(path).equalTo(row::getPath)
            .set(method).equalTo(row::getMethod)
            .set(createBy).equalTo(row::getCreateBy)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateBy).equalTo(row::getUpdateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .set(valid).equalTo(row::getValid)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Api row) {
        return update(c ->
            c.set(app).equalToWhenPresent(row::getApp)
            .set(path).equalToWhenPresent(row::getPath)
            .set(method).equalToWhenPresent(row::getMethod)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateBy).equalToWhenPresent(row::getUpdateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .set(valid).equalToWhenPresent(row::getValid)
            .where(id, isEqualTo(row::getId))
        );
    }
}