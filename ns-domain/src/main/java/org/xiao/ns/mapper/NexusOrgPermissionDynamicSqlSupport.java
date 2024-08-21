package org.xiao.ns.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class NexusOrgPermissionDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final NexusOrgPermission nexusOrgPermission = new NexusOrgPermission();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = nexusOrgPermission.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> oid = nexusOrgPermission.oid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> permissionId = nexusOrgPermission.permissionId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> createBy = nexusOrgPermission.createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = nexusOrgPermission.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class NexusOrgPermission extends AliasableSqlTable<NexusOrgPermission> {
        public final SqlColumn<Long> id = column("F_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> oid = column("F_OID", JDBCType.BIGINT);

        public final SqlColumn<Long> permissionId = column("F_PERMISSION_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> createBy = column("CREATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public NexusOrgPermission() {
            super("t_nexus_org_permission", NexusOrgPermission::new);
        }
    }
}