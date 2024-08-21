package org.xiao.ns.domain.po;

import jakarta.annotation.Generated;
import java.time.LocalDateTime;

public class NexusApiPermission {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long apiId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long permissionId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long createBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getApiId() {
        return apiId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getPermissionId() {
        return permissionId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
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
}