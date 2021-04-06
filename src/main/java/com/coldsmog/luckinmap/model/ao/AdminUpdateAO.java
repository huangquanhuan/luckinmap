package com.coldsmog.luckinmap.model.ao;

import java.io.Serializable;

/**
 * @Description: 更新admin 需要的ao
 * @Author: quanhuan.huang
 * @Date: 2019/11/3 22:05
 */
public class AdminUpdateAO implements Serializable {
    private static final long serialVersionUID = 6592680098588798875L;
    /**
     * 主键
     */

    private Integer id;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 姓名
     */
    private String name;
    /**
     * 头像
     */
    private String image;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 性别 性别 0：男 1：女
     */
    private Integer sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return "AdminUpdateAO{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                '}';
    }
}
