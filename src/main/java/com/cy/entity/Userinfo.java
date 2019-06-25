package com.cy.entity;

import java.util.Date;

public class Userinfo {
    private Integer id;

    private String name;

    private String password;

    private Date date;

    private Date updatetime;

    private String code;

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
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                " id='"+id + '\'' +
                " name='"+name + '\'' +
                " password='"+password + '\'' +
                " date='"+date +
                " updateTime='"+updatetime + '\''
                +" }";
    }
}