package org.xiao.ns.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class RouteDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Route route = new Route();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = route.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> pid = route.pid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> app = route.app;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> uri = route.uri;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> mode = route.mode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> path = route.path;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = route.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> cache = route.cache;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> type = route.type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> title = route.title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> icon = route.icon;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> linkage = route.linkage;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> home = route.home;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> hide = route.hide;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> sort = route.sort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> createBy = route.createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = route.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updateBy = route.updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateTime = route.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> valid = route.valid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> linkageConfig = route.linkageConfig;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Route extends AliasableSqlTable<Route> {
        public final SqlColumn<Long> id = column("F_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> pid = column("F_PID", JDBCType.BIGINT);

        public final SqlColumn<String> app = column("F_APP", JDBCType.VARCHAR);

        public final SqlColumn<String> uri = column("F_URI", JDBCType.VARCHAR);

        public final SqlColumn<String> mode = column("F_MODE", JDBCType.VARCHAR);

        public final SqlColumn<String> path = column("F_PATH", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("F_NAME", JDBCType.VARCHAR);

        public final SqlColumn<String> cache = column("F_CACHE", JDBCType.VARCHAR);

        public final SqlColumn<String> type = column("F_TYPE", JDBCType.VARCHAR);

        public final SqlColumn<String> title = column("F_TITLE", JDBCType.VARCHAR);

        public final SqlColumn<String> icon = column("F_ICON", JDBCType.VARCHAR);

        public final SqlColumn<String> linkage = column("F_LINKAGE", JDBCType.VARCHAR);

        public final SqlColumn<String> home = column("F_HOME", JDBCType.VARCHAR);

        public final SqlColumn<String> hide = column("F_HIDE", JDBCType.VARCHAR);

        public final SqlColumn<Integer> sort = column("F_SORT", JDBCType.INTEGER);

        public final SqlColumn<Long> createBy = column("CREATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateBy = column("UPDATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("UPDATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<String> valid = column("VALID", JDBCType.VARCHAR);

        public final SqlColumn<String> linkageConfig = column("F_LINKAGE_CONFIG", JDBCType.LONGVARCHAR);

        public Route() {
            super("t_route", Route::new);
        }
    }
}