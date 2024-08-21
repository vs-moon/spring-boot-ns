package org.xiao.ns.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class AppDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final App app = new App();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = app.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> code = app.code;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = app.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> createBy = app.createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = app.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updateBy = app.updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateTime = app.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> valid = app.valid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class App extends AliasableSqlTable<App> {
        public final SqlColumn<Long> id = column("F_ID", JDBCType.BIGINT);

        public final SqlColumn<String> code = column("F_CODE", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("F_NAME", JDBCType.VARCHAR);

        public final SqlColumn<Long> createBy = column("CREATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateBy = column("UPDATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("UPDATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<String> valid = column("VALID", JDBCType.VARCHAR);

        public App() {
            super("t_app", App::new);
        }
    }
}