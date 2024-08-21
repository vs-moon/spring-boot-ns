package org.xiao.ns.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class NexusOrgRouteDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final NexusOrgRoute nexusOrgRoute = new NexusOrgRoute();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = nexusOrgRoute.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> oid = nexusOrgRoute.oid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> routeId = nexusOrgRoute.routeId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> createBy = nexusOrgRoute.createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = nexusOrgRoute.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class NexusOrgRoute extends AliasableSqlTable<NexusOrgRoute> {
        public final SqlColumn<Long> id = column("F_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> oid = column("F_OID", JDBCType.BIGINT);

        public final SqlColumn<Long> routeId = column("F_ROUTE_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> createBy = column("CREATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public NexusOrgRoute() {
            super("t_nexus_org_route", NexusOrgRoute::new);
        }
    }
}