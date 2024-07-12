package org.xiao.ns.domain.po;

import jakarta.annotation.Generated;
import java.time.LocalDateTime;

public class Member {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String username;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String password;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String nationality;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String identity;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String phone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime birthday;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String sex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String describe;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer tryCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime lockTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime expireTime;

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
    public String getUsername() {
        return username;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPassword() {
        return password;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getNationality() {
        return nationality;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getIdentity() {
        return identity;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPhone() {
        return phone;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getBirthday() {
        return birthday;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getSex() {
        return sex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDescribe() {
        return describe;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getTryCount() {
        return tryCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTryCount(Integer tryCount) {
        this.tryCount = tryCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getLockTime() {
        return lockTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLockTime(LocalDateTime lockTime) {
        this.lockTime = lockTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
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