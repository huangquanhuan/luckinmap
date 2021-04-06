package com.coldsmog.luckinmap.model.ao;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 登录AO
 * @Author: quanhuan.huang
 * @Date: 2019/11/1 17:46
 */
public class LoginAO implements Serializable {
    private static final long serialVersionUID = 6556273457617108541L;
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

    @Override
    public String toString() {
        return "LoginAO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
