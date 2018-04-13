package com.masterlee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class product {
    private Integer id;

    private String name;

    private Integer number;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;

    private String description;

    private Boolean ifdelete;

    public void setIfdelete(Boolean ifdelete) {
        this.ifdelete = ifdelete;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Boolean getIfdelete() {
        return ifdelete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}