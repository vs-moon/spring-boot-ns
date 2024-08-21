package org.xiao.ns.domain.po;

import jakarta.annotation.Generated;
import java.time.LocalDateTime;

public class NexusOrgUser {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long oid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long uid;

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
    public Long getOid() {
        return oid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOid(Long oid) {
        this.oid = oid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUid() {
        return uid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUid(Long uid) {
        this.uid = uid;
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