package com.coldsmog.luckinmap.model.ao;


import java.io.Serializable;

/**
 * @Description: 分页查询admin 的AO
 * @Author: quanhuan.huang
 * @Date: 2019/11/4 13:13
 */
public class AdminPageAO extends BasePageAO implements Serializable {
    private static final long serialVersionUID = 4222159441973251179L;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 状态
     */
    private Integer status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdminPageAO{" +
                "username='" + username + '\'' +
                ", status=" + status +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
