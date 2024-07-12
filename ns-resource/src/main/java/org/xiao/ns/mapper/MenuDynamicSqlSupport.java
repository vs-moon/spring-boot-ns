package org.xiao.ns.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class MenuDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Menu menu = new Menu();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = menu.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> parentId = menu.parentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> source = menu.source;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> modulePath = menu.modulePath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> jumpMode = menu.jumpMode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> routePath = menu.routePath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> routeName = menu.routeName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> routeAlive = menu.routeAlive;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> menuMode = menu.menuMode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> menuName = menu.menuName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> menuIcon = menu.menuIcon;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> sort = menu.sort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> createBy = menu.createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = menu.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updateBy = menu.updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateTime = menu.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> valid = menu.valid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Menu extends AliasableSqlTable<Menu> {
        public final SqlColumn<Long> id = column("F_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> parentId = column("F_PARENT_ID", JDBCType.BIGINT);

        public final SqlColumn<String> source = column("F_SOURCE", JDBCType.VARCHAR);

        public final SqlColumn<String> modulePath = column("F_MODULE_PATH", JDBCType.VARCHAR);

        public final SqlColumn<String> jumpMode = column("F_JUMP_MODE", JDBCType.VARCHAR);

        public final SqlColumn<String> routePath = column("F_ROUTE_PATH", JDBCType.VARCHAR);

        public final SqlColumn<String> routeName = column("F_ROUTE_NAME", JDBCType.VARCHAR);

        public final SqlColumn<String> routeAlive = column("F_ROUTE_ALIVE", JDBCType.VARCHAR);

        public final SqlColumn<String> menuMode = column("F_MENU_MODE", JDBCType.VARCHAR);

        public final SqlColumn<String> menuName = column("F_MENU_NAME", JDBCType.VARCHAR);

        public final SqlColumn<String> menuIcon = column("F_MENU_ICON", JDBCType.VARCHAR);

        public final SqlColumn<Integer> sort = column("SORT", JDBCType.INTEGER);

        public final SqlColumn<Long> createBy = column("CREATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("CREATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateBy = column("UPDATE_BY", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("UPDATE_TIME", JDBCType.TIMESTAMP);

        public final SqlColumn<String> valid = column("VALID", JDBCType.VARCHAR);

        public Menu() {
            super("t_menu", Menu::new);
        }
    }
}