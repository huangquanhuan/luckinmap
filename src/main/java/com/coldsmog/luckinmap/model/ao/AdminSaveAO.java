package com.coldsmog.luckinmap.model.ao;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 保存admin需要的AO
 * @Author: quanhuan.huang
 * @Date: 2019/11/3 22:04
 */
public class AdminSaveAO implements Serializable {
    private static final long serialVersionUID = 1772677111042600763L;
    /**
     * 角色id
     */
    @NotNull
    private Integer roleId;
    /**
     * 用户名
     */
    @NotNull
    private String username;
    /**
     * 密码
     */
    @NotNull
    private String password;
    /**
     * 姓名
     */
    @NotNull
    private String name;
    /**
     * 头像
     */
    @NotNull
    private String image;
    /**
     * 手机号
     */
    @NotNull
    private String phone;
    /**
     * 性别 性别 0：男 1：女
     */
    @NotNull
    private Integer sex;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "AdminSaveAO{" +
                "roleId=" + roleId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                '}';
    }
}
