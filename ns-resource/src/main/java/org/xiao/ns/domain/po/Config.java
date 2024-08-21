package org.xiao.ns.domain.po;

import jakarta.annotation.Generated;
import java.time.LocalDateTime;

public class Config {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String app;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String dataType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String attributeName;

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
    private String attributeValue;

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
    public String getDataType() {
        return dataType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAttributeName() {
        return attributeName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName == null ? null : attributeName.trim();
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAttributeValue() {
        return attributeValue;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue == null ? null : attributeValue.trim();
    }
}