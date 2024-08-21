package org.xiao.ns.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class NexusRoleRouteDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final NexusRoleRoute nexusRoleRoute = new NexusRoleRoute();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = nexusRoleRoute.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> rid = nexusRoleRoute.rid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> routeId = nexusRoleRoute.routeId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> createBy = nexusRoleRoute.createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = nexusRoleRoute.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class NexusRoleRoute extends AliasableSqlTable<NexusRoleRoute> {
        public final SqlColumn<Long> id = column("F_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> rid = column("F_RID", JDBCType.BIGINT);

        public final SqlColumn<Long> routeId = column("F_ROUTE_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> createBy = column("CREATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public NexusRoleRoute() {
            super("t_nexus_role_route", NexusRoleRoute::new);
        }
    }
}