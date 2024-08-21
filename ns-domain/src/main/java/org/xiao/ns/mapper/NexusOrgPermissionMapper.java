package org.xiao.ns.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.xiao.ns.mapper.NexusOrgPermissionDynamicSqlSupport.*;

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
import org.xiao.ns.domain.po.NexusOrgPermission;

@Mapper
public interface NexusOrgPermissionMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<NexusOrgPermission>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, oid, permissionId, createBy, createTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="NexusOrgPermissionResult", value = {
        @Result(column="F_ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="F_OID", property="oid", jdbcType=JdbcType.BIGINT),
        @Result(column="F_PERMISSION_ID", property="permissionId", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_BY", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<NexusOrgPermission> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("NexusOrgPermissionResult")
    Optional<NexusOrgPermission> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, nexusOrgPermission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, nexusOrgPermission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(NexusOrgPermission row) {
        return MyBatis3Utils.insert(this::insert, row, nexusOrgPermission, c ->
            c.map(id).toProperty("id")
            .map(oid).toProperty("oid")
            .map(permissionId).toProperty("permissionId")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<NexusOrgPermission> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, nexusOrgPermission, c ->
            c.map(id).toProperty("id")
            .map(oid).toProperty("oid")
            .map(permissionId).toProperty("permissionId")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(NexusOrgPermission row) {
        return MyBatis3Utils.insert(this::insert, row, nexusOrgPermission, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(oid).toPropertyWhenPresent("oid", row::getOid)
            .map(permissionId).toPropertyWhenPresent("permissionId", row::getPermissionId)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<NexusOrgPermission> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, nexusOrgPermission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<NexusOrgPermission> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, nexusOrgPermission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<NexusOrgPermission> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, nexusOrgPermission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<NexusOrgPermission> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, nexusOrgPermission, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(NexusOrgPermission row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(oid).equalTo(row::getOid)
                .set(permissionId).equalTo(row::getPermissionId)
                .set(createBy).equalTo(row::getCreateBy)
                .set(createTime).equalTo(row::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(NexusOrgPermission row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(oid).equalToWhenPresent(row::getOid)
                .set(permissionId).equalToWhenPresent(row::getPermissionId)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(createTime).equalToWhenPresent(row::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(NexusOrgPermission row) {
        return update(c ->
            c.set(oid).equalTo(row::getOid)
            .set(permissionId).equalTo(row::getPermissionId)
            .set(createBy).equalTo(row::getCreateBy)
            .set(createTime).equalTo(row::getCreateTime)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(NexusOrgPermission row) {
        return update(c ->
            c.set(oid).equalToWhenPresent(row::getOid)
            .set(permissionId).equalToWhenPresent(row::getPermissionId)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .where(id, isEqualTo(row::getId))
        );
    }
}