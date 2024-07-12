package org.xiao.ns.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class MemberDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Member member = new Member();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = member.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> username = member.username;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> password = member.password;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> nationality = member.nationality;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> identity = member.identity;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> phone = member.phone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> birthday = member.birthday;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> sex = member.sex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> describe = member.describe;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> tryCount = member.tryCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> lockTime = member.lockTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> expireTime = member.expireTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> createBy = member.createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = member.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updateBy = member.updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateTime = member.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> valid = member.valid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Member extends AliasableSqlTable<Member> {
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

        public Member() {
            super("t_member", Member::new);
        }
    }
}