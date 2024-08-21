package org.xiao.ns.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.xiao.ns.mapper.UserDynamicSqlSupport.*;

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
import org.xiao.ns.domain.po.User;

@Mapper
public interface UserMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<User>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, username, password, nationality, identity, phone, birthday, sex, describe, tryCount, lockTime, expireTime, createBy, createTime, updateBy, updateTime, valid);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="F_ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="F_USERNAME", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_NATIONALITY", property="nationality", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_IDENTITY", property="identity", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_PHONE", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_BIRTHDAY", property="birthday", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="F_SEX", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_DESCRIBE", property="describe", jdbcType=JdbcType.VARCHAR),
        @Result(column="F_TRY_COUNT", property="tryCount", jdbcType=JdbcType.INTEGER),
        @Result(column="F_LOCK_TIME", property="lockTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="F_EXPIRE_TIME", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_BY", property="createBy", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_BY", property="updateBy", jdbcType=JdbcType.BIGINT),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="VALID", property="valid", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    Optional<User> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(User row) {
        return MyBatis3Utils.insert(this::insert, row, user, c ->
            c.map(id).toProperty("id")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(nationality).toProperty("nationality")
            .map(identity).toProperty("identity")
            .map(phone).toProperty("phone")
            .map(birthday).toProperty("birthday")
            .map(sex).toProperty("sex")
            .map(describe).toProperty("describe")
            .map(tryCount).toProperty("tryCount")
            .map(lockTime).toProperty("lockTime")
            .map(expireTime).toProperty("expireTime")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(valid).toProperty("valid")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<User> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, user, c ->
            c.map(id).toProperty("id")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(nationality).toProperty("nationality")
            .map(identity).toProperty("identity")
            .map(phone).toProperty("phone")
            .map(birthday).toProperty("birthday")
            .map(sex).toProperty("sex")
            .map(describe).toProperty("describe")
            .map(tryCount).toProperty("tryCount")
            .map(lockTime).toProperty("lockTime")
            .map(expireTime).toProperty("expireTime")
            .map(createBy).toProperty("createBy")
            .map(createTime).toProperty("createTime")
            .map(updateBy).toProperty("updateBy")
            .map(updateTime).toProperty("updateTime")
            .map(valid).toProperty("valid")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(User row) {
        return MyBatis3Utils.insert(this::insert, row, user, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(username).toPropertyWhenPresent("username", row::getUsername)
            .map(password).toPropertyWhenPresent("password", row::getPassword)
            .map(nationality).toPropertyWhenPresent("nationality", row::getNationality)
            .map(identity).toPropertyWhenPresent("identity", row::getIdentity)
            .map(phone).toPropertyWhenPresent("phone", row::getPhone)
            .map(birthday).toPropertyWhenPresent("birthday", row::getBirthday)
            .map(sex).toPropertyWhenPresent("sex", row::getSex)
            .map(describe).toPropertyWhenPresent("describe", row::getDescribe)
            .map(tryCount).toPropertyWhenPresent("tryCount", row::getTryCount)
            .map(lockTime).toPropertyWhenPresent("lockTime", row::getLockTime)
            .map(expireTime).toPropertyWhenPresent("expireTime", row::getExpireTime)
            .map(createBy).toPropertyWhenPresent("createBy", row::getCreateBy)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateBy).toPropertyWhenPresent("updateBy", row::getUpdateBy)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
            .map(valid).toPropertyWhenPresent("valid", row::getValid)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<User> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<User> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<User> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<User> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(User row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(username).equalTo(row::getUsername)
                .set(password).equalTo(row::getPassword)
                .set(nationality).equalTo(row::getNationality)
                .set(identity).equalTo(row::getIdentity)
                .set(phone).equalTo(row::getPhone)
                .set(birthday).equalTo(row::getBirthday)
                .set(sex).equalTo(row::getSex)
                .set(describe).equalTo(row::getDescribe)
                .set(tryCount).equalTo(row::getTryCount)
                .set(lockTime).equalTo(row::getLockTime)
                .set(expireTime).equalTo(row::getExpireTime)
                .set(createBy).equalTo(row::getCreateBy)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateBy).equalTo(row::getUpdateBy)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(valid).equalTo(row::getValid);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(User row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(username).equalToWhenPresent(row::getUsername)
                .set(password).equalToWhenPresent(row::getPassword)
                .set(nationality).equalToWhenPresent(row::getNationality)
                .set(identity).equalToWhenPresent(row::getIdentity)
                .set(phone).equalToWhenPresent(row::getPhone)
                .set(birthday).equalToWhenPresent(row::getBirthday)
                .set(sex).equalToWhenPresent(row::getSex)
                .set(describe).equalToWhenPresent(row::getDescribe)
                .set(tryCount).equalToWhenPresent(row::getTryCount)
                .set(lockTime).equalToWhenPresent(row::getLockTime)
                .set(expireTime).equalToWhenPresent(row::getExpireTime)
                .set(createBy).equalToWhenPresent(row::getCreateBy)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(valid).equalToWhenPresent(row::getValid);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(User row) {
        return update(c ->
            c.set(username).equalTo(row::getUsername)
            .set(password).equalTo(row::getPassword)
            .set(nationality).equalTo(row::getNationality)
            .set(identity).equalTo(row::getIdentity)
            .set(phone).equalTo(row::getPhone)
            .set(birthday).equalTo(row::getBirthday)
            .set(sex).equalTo(row::getSex)
            .set(describe).equalTo(row::getDescribe)
            .set(tryCount).equalTo(row::getTryCount)
            .set(lockTime).equalTo(row::getLockTime)
            .set(expireTime).equalTo(row::getExpireTime)
            .set(createBy).equalTo(row::getCreateBy)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateBy).equalTo(row::getUpdateBy)
            .set(updateTime).equalTo(row::getUpdateTime)
            .set(valid).equalTo(row::getValid)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(User row) {
        return update(c ->
            c.set(username).equalToWhenPresent(row::getUsername)
            .set(password).equalToWhenPresent(row::getPassword)
            .set(nationality).equalToWhenPresent(row::getNationality)
            .set(identity).equalToWhenPresent(row::getIdentity)
            .set(phone).equalToWhenPresent(row::getPhone)
            .set(birthday).equalToWhenPresent(row::getBirthday)
            .set(sex).equalToWhenPresent(row::getSex)
            .set(describe).equalToWhenPresent(row::getDescribe)
            .set(tryCount).equalToWhenPresent(row::getTryCount)
            .set(lockTime).equalToWhenPresent(row::getLockTime)
            .set(expireTime).equalToWhenPresent(row::getExpireTime)
            .set(createBy).equalToWhenPresent(row::getCreateBy)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateBy).equalToWhenPresent(row::getUpdateBy)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .set(valid).equalToWhenPresent(row::getValid)
            .where(id, isEqualTo(row::getId))
        );
    }
}