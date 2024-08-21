package org.xiao.ns.mapper;

import static org.xiao.ns.mapper.NexusOrgRouteDynamicSqlSupport.*;

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
import org.xiao.ns.domain.po.NexusOrgRoute;

@Mapper
public interface NexusOrgRouteMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<NexusOrgRoute>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, oid, routeId, createBy, createTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="NexusOrgRouteResult", value = {
        @Result(column="F_ID", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="F_OID", property="oid", jdbcType=JdbcType.BIGINT),
        @Result(column="F_ROUTE_ID", property="routeId", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_BY", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<NexusOrgRoute> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("NexusOrgRouteResult")
    Optional<NexusOrgRoute> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, nexusOrgRoute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, nexusOrgRoute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(NexusOrgRoute row) {
        return MyBatis3Utils.insert(this::insert, row, nexusOrgRoute, c ->
            c.map(id).toProperty("id")
            .map(oid).toProperty("oid")
            .map(routeId).toProperty("routeId")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<NexusOrgRoute> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, nexusOrgRoute, c ->
            c.map(id).toProperty("id")
            .map(oid).toProperty("oid")
            .map(routeId).toProperty("routeId")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(NexusOrgRoute row) {
        return MyBatis3Utils.insert(this::insert, row, nexusOrgRoute, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(oid).toPropertyWhenPresent("oid", row::getOid)
            .map(routeId).toPropertyWhenPresent("routeId", row::getRouteId)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<NexusOrgRoute> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, nexusOrgRoute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<NexusOrgRoute> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, nexusOrgRoute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<NexusOrgRoute> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, nexusOrgRoute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, nexusOrgRoute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(NexusOrgRoute row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(oid).equalTo(row::getOid)
                .set(routeId).equalTo(row::getRouteId)
                .set(createBy).equalTo(row::getCreateBy)
                .set(createTime).equalTo(row::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(NexusOrgRoute row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(oid).equalToWhenPresent(row::getOid)
                .set(routeId).equalToWhenPresent(row::getRouteId)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(createTime).equalToWhenPresent(row::getCreateTime);
    }
}