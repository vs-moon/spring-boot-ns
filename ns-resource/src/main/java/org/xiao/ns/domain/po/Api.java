package org.xiao.ns.domain.po;

import jakarta.annotation.Generated;
import java.time.LocalDateTime;

public class Api {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String app;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String path;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String method;

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
    public String getApp() {
        return app;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setApp(String app) {
        this.app = app == null ? null : app.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPath() {
        return path;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getMethod() {
        return method;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
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