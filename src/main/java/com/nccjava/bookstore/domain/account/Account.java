package com.nccjava.bookstore.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nccjava.bookstore.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Account extends BaseEntity {

    @NotEmpty(message = "用户名不允许为空")
    private String username;

    // 密码不参与序列化（但是参与反序列化）不参与更新，参与插入
    // 意味着密码字段不会在获取对象（很多操作都会关联用户对象）时候泄漏出去
    // 也是【修改密码】的功能无法以用户对象资源的接口处理，需要单独的接口处理，因为更新对象时密码不会更新
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(updatable = false)
    private String password;

    @NotEmpty(message = "用户姓名不允许为空")
    private String name;

    private String avater;

    @Pattern(regexp = "1\\d{10}",message = "手机格式不正确")
    private String telephone;

    @Email(message = "邮箱格式不正确")
    private String email;

    private String location;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
