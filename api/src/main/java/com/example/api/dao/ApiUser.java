package com.example.api.dao;

import lombok.Data;

import java.util.List;

@Data// 是 lombok 的注解，自动生成Getter，Setter，toString，构造函数等
public class ApiUser {
    private Integer id;
    private String userName;
    private String password;
    private String realName;
    private List<String> roles;
    private List<String> permissions;

    public ApiUser(Integer id, String userName, String password, String realName, List<String> roles, List<String> permissions) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.roles = roles;
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
