package org.xiao.ns.mapper;

import static org.xiao.ns.mapper.NexusRoleRouteDynamicSqlSupport.*;

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
import org.xiao.ns.domain.po.NexusRoleRoute;

@Mapper
public interface NexusRoleRouteMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<NexusRoleRoute>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, rid, routeId, createBy, createTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="NexusRoleRouteResult", value = {
        @Result(column="F_ID", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="F_RID", property="rid", jdbcType=JdbcType.BIGINT),
        @Result(column="F_ROUTE_ID", property="routeId", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_BY", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<NexusRoleRoute> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("NexusRoleRouteResult")
    Optional<NexusRoleRoute> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, nexusRoleRoute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, nexusRoleRoute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(NexusRoleRoute row) {
        return MyBatis3Utils.insert(this::insert, row, nexusRoleRoute, c ->
            c.map(id).toProperty("id")
            .map(rid).toProperty("rid")
            .map(routeId).toProperty("routeId")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<NexusRoleRoute> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, nexusRoleRoute, c ->
            c.map(id).toProperty("id")
            .map(rid).toProperty("rid")
            .map(routeId).toProperty("routeId")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(NexusRoleRoute row) {
        return MyBatis3Utils.insert(this::insert, row, nexusRoleRoute, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(rid).toPropertyWhenPresent("rid", row::getRid)
            .map(routeId).toPropertyWhenPresent("routeId", row::getRouteId)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<NexusRoleRoute> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, nexusRoleRoute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<NexusRoleRoute> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, nexusRoleRoute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<NexusRoleRoute> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, nexusRoleRoute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, nexusRoleRoute, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(NexusRoleRoute row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(rid).equalTo(row::getRid)
                .set(routeId).equalTo(row::getRouteId)
                .set(createBy).equalTo(row::getCreateBy)
                .set(createTime).equalTo(row::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(NexusRoleRoute row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(rid).equalToWhenPresent(row::getRid)
                .set(routeId).equalToWhenPresent(row::getRouteId)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(createTime).equalToWhenPresent(row::getCreateTime);
    }
}