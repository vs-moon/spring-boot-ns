package org.xiao.ns.mapper;

import static org.xiao.ns.mapper.NexusRoleMenuDynamicSqlSupport.*;

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
import org.xiao.ns.domain.po.NexusRoleMenu;

@Mapper
public interface NexusRoleMenuMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<NexusRoleMenu>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, source, roleId, menuId, createBy, createTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="NexusRoleMenuResult", value = {
        @Result(column="F_ID", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="F_SOURCE", property="source", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_ROLE_ID", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="F_MENU_ID", property="menuId", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_BY", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<NexusRoleMenu> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("NexusRoleMenuResult")
    Optional<NexusRoleMenu> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, nexusRoleMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, nexusRoleMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(NexusRoleMenu row) {
        return MyBatis3Utils.insert(this::insert, row, nexusRoleMenu, c ->
            c.map(id).toProperty("id")
            .map(source).toProperty("source")
            .map(roleId).toProperty("roleId")
            .map(menuId).toProperty("menuId")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<NexusRoleMenu> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, nexusRoleMenu, c ->
            c.map(id).toProperty("id")
            .map(source).toProperty("source")
            .map(roleId).toProperty("roleId")
            .map(menuId).toProperty("menuId")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(NexusRoleMenu row) {
        return MyBatis3Utils.insert(this::insert, row, nexusRoleMenu, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(source).toPropertyWhenPresent("source", row::getSource)
            .map(roleId).toPropertyWhenPresent("roleId", row::getRoleId)
            .map(menuId).toPropertyWhenPresent("menuId", row::getMenuId)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<NexusRoleMenu> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, nexusRoleMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<NexusRoleMenu> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, nexusRoleMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<NexusRoleMenu> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, nexusRoleMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, nexusRoleMenu, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(NexusRoleMenu row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(source).equalTo(row::getSource)
                .set(roleId).equalTo(row::getRoleId)
                .set(menuId).equalTo(row::getMenuId)
                .set(createBy).equalTo(row::getCreateBy)
                .set(createTime).equalTo(row::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(NexusRoleMenu row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(source).equalToWhenPresent(row::getSource)
                .set(roleId).equalToWhenPresent(row::getRoleId)
                .set(menuId).equalToWhenPresent(row::getMenuId)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(createTime).equalToWhenPresent(row::getCreateTime);
    }
}