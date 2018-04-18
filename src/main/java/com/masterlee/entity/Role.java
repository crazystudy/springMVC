package com.masterlee.entity;

import java.util.Date;

public class Role {
    private String id;

    private String roleName;

    private Integer roleType;

    private Integer roleLeavel;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getRoleLeavel() {
        return roleLeavel;
    }

    public void setRoleLeavel(Integer roleLeavel) {
        this.roleLeavel = roleLeavel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}