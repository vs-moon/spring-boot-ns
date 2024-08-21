package org.xiao.ns.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ConfigDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Config config = new Config();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = config.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> app = config.app;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> dataType = config.dataType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> attributeName = config.attributeName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> createBy = config.createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = config.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updateBy = config.updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateTime = config.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> valid = config.valid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> attributeValue = config.attributeValue;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Config extends AliasableSqlTable<Config> {
        public final SqlColumn<Long> id = column("F_ID", JDBCType.BIGINT);

        public final SqlColumn<String> app = column("F_APP", JDBCType.VARCHAR);

        public final SqlColumn<String> dataType = column("F_DATA_TYPE", JDBCType.VARCHAR);

        public final SqlColumn<String> attributeName = column("F_ATTRIBUTE_NAME", JDBCType.VARCHAR);

        public final SqlColumn<Long> createBy = column("CREATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateBy = column("UPDATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("UPDATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<String> valid = column("VALID", JDBCType.VARCHAR);

        public final SqlColumn<String> attributeValue = column("F_ATTRIBUTE_VALUE", JDBCType.LONGVARCHAR);

        public Config() {
            super("t_config", Config::new);
        }
    }
}