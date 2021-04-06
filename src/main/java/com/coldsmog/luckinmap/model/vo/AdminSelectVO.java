package com.coldsmog.luckinmap.model.vo;

/**
 * @Description: 用户select的vo 全部管理员的id和username
 * @Author: quanhuan.huang
 * @Date: 2019/11/11 10:49
 */
public class AdminSelectVO {
    /**
     * admin 主键
     */
    Integer id;
    /**
     * admin 的姓名
     */
    String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "RoleSelectVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
