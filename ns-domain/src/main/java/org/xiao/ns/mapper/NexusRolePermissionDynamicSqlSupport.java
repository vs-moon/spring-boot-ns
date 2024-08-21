package org.xiao.ns.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class NexusRolePermissionDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final NexusRolePermission nexusRolePermission = new NexusRolePermission();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = nexusRolePermission.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> rid = nexusRolePermission.rid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> permissionId = nexusRolePermission.permissionId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> createBy = nexusRolePermission.createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = nexusRolePermission.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class NexusRolePermission extends AliasableSqlTable<NexusRolePermission> {
        public final SqlColumn<Long> id = column("F_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> rid = column("F_RID", JDBCType.BIGINT);

        public final SqlColumn<Long> permissionId = column("F_PERMISSION_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> createBy = column("CREATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public NexusRolePermission() {
            super("t_nexus_role_permission", NexusRolePermission::new);
        }
    }
}