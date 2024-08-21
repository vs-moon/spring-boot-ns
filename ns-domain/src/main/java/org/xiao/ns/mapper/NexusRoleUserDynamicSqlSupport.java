package org.xiao.ns.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class NexusRoleUserDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final NexusRoleUser nexusRoleUser = new NexusRoleUser();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = nexusRoleUser.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> rid = nexusRoleUser.rid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> uid = nexusRoleUser.uid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> createBy = nexusRoleUser.createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = nexusRoleUser.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class NexusRoleUser extends AliasableSqlTable<NexusRoleUser> {
        public final SqlColumn<Long> id = column("F_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> rid = column("F_RID", JDBCType.BIGINT);

        public final SqlColumn<Long> uid = column("F_UID", JDBCType.BIGINT);

        public final SqlColumn<Long> createBy = column("CREATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public NexusRoleUser() {
            super("t_nexus_role_user", NexusRoleUser::new);
        }
    }
}