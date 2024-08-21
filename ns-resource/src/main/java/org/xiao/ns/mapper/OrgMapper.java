package org.xiao.ns.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.xiao.ns.mapper.OrgDynamicSqlSupport.*;

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
import org.xiao.ns.domain.po.Org;

@Mapper
public interface OrgMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Org>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, pid, app, code, name, createBy, createTime, updateBy, updateTime, valid);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrgResult", value = {
        @Result(column="F_ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="F_PID", property="pid", jdbcType=JdbcType.BIGINT),
        @Result(column="F_APP", property="app", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_CODE", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_BY", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_BY", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="VALID", property="valid", jdbcType=JdbcType.VARCHAR)
    })
    List<Org> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrgResult")
    Optional<Org> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, org, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, org, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Org row) {
        return MyBatis3Utils.insert(this::insert, row, org, c ->
            c.map(id).toProperty("id")
            .map(pid).toProperty("pid")
            .map(app).toProperty("app")
            .map(code).toProperty("code")
            .map(name).toProperty("name")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(valid).toProperty("valid")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Org> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, org, c ->
            c.map(id).toProperty("id")
            .map(pid).toProperty("pid")
            .map(app).toProperty("app")
            .map(code).toProperty("code")
            .map(name).toProperty("name")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(valid).toProperty("valid")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Org row) {
        return MyBatis3Utils.insert(this::insert, row, org, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(pid).toPropertyWhenPresent("pid", row::getPid)
            .map(app).toPropertyWhenPresent("app", row::getApp)
            .map(code).toPropertyWhenPresent("code", row::getCode)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateBy).toPropertyWhenPresent("updateBy", row::getUpdateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
            .map(valid).toPropertyWhenPresent("valid", row::getValid)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Org> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, org, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Org> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, org, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Org> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, org, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Org> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, org, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Org row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(pid).equalTo(row::getPid)
                .set(app).equalTo(row::getApp)
                .set(code).equalTo(row::getCode)
                .set(name).equalTo(row::getName)
                .set(createBy).equalTo(row::getCreateBy)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateBy).equalTo(row::getUpdateBy)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(valid).equalTo(row::getValid);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Org row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(pid).equalToWhenPresent(row::getPid)
                .set(app).equalToWhenPresent(row::getApp)
                .set(code).equalToWhenPresent(row::getCode)
                .set(name).equalToWhenPresent(row::getName)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(valid).equalToWhenPresent(row::getValid);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Org row) {
        return update(c ->
            c.set(pid).equalTo(row::getPid)
            .set(app).equalTo(row::getApp)
            .set(code).equalTo(row::getCode)
            .set(name).equalTo(row::getName)
            .set(createBy).equalTo(row::getCreateBy)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateBy).equalTo(row::getUpdateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .set(valid).equalTo(row::getValid)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Org row) {
        return update(c ->
            c.set(pid).equalToWhenPresent(row::getPid)
            .set(app).equalToWhenPresent(row::getApp)
            .set(code).equalToWhenPresent(row::getCode)
            .set(name).equalToWhenPresent(row::getName)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateBy).equalToWhenPresent(row::getUpdateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .set(valid).equalToWhenPresent(row::getValid)
            .where(id, isEqualTo(row::getId))
        );
    }
}