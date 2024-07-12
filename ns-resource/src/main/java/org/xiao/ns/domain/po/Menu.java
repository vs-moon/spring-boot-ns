package org.xiao.ns.domain.po;

import jakarta.annotation.Generated;
import java.time.LocalDateTime;

public class Menu {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long parentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String source;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String modulePath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String jumpMode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String routePath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String routeName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String routeAlive;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String menuMode;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String menuName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String menuIcon;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer sort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String valid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getParentId() {
        return parentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getSource() {
        return source;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getModulePath() {
        return modulePath;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setModulePath(String modulePath) {
        this.modulePath = modulePath == null ? null : modulePath.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getJumpMode() {
        return jumpMode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setJumpMode(String jumpMode) {
        this.jumpMode = jumpMode == null ? null : jumpMode.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRoutePath() {
        return routePath;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRoutePath(String routePath) {
        this.routePath = routePath == null ? null : routePath.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRouteName() {
        return routeName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRouteName(String routeName) {
        this.routeName = routeName == null ? null : routeName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getRouteAlive() {
        return routeAlive;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRouteAlive(String routeAlive) {
        this.routeAlive = routeAlive == null ? null : routeAlive.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getMenuMode() {
        return menuMode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMenuMode(String menuMode) {
        this.menuMode = menuMode == null ? null : menuMode.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getMenuName() {
        return menuName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getMenuIcon() {
        return menuIcon;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getSort() {
        return sort;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getCreateBy() {
        return createBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUpdateBy() {
        return updateBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getValid() {
        return valid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setValid(String valid) {
        this.valid = valid == null ? null : valid.trim();
    }
}