package org.xiao.ns.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UserDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final User user = new User();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = user.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> username = user.username;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> password = user.password;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> nationality = user.nationality;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> identity = user.identity;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> phone = user.phone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> birthday = user.birthday;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> sex = user.sex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> describe = user.describe;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> tryCount = user.tryCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> lockTime = user.lockTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> expireTime = user.expireTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> createBy = user.createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = user.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updateBy = user.updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateTime = user.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> valid = user.valid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class User extends AliasableSqlTable<User> {
        public final SqlColumn<Long> id = column("F_ID", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("F_USERNAME", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("F_PASSWORD", JDBCType.VARCHAR);

        public final SqlColumn<String> nationality = column("F_NATIONALITY", JDBCType.VARCHAR);

        public final SqlColumn<String> identity = column("F_IDENTITY", JDBCType.VARCHAR);

        public final SqlColumn<String> phone = column("F_PHONE", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> birthday = column("F_BIRTHDAY", JDBCType.TIMESTAMP);

        public final SqlColumn<String> sex = column("F_SEX", JDBCType.VARCHAR);

        public final SqlColumn<String> describe = column("F_DESCRIBE", JDBCType.VARCHAR);

        public final SqlColumn<Integer> tryCount = column("F_TRY_COUNT", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> lockTime = column("F_LOCK_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> expireTime = column("F_EXPIRE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createBy = column("CREATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateBy = column("UPDATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("UPDATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<String> valid = column("VALID", JDBCType.VARCHAR);

        public User() {
            super("t_user", User::new);
        }
    }
}