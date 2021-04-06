package com.coldsmog.luckinmap.model.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 重置密码DTO 手机号 | id+旧密码 二者选一
 * @Author: quanhuan.huang
 * @Date: 2019/11/6 08:44
 */
public class ResetPasswordDto implements Serializable {
    private static final long serialVersionUID = 5369509698238895195L;
    /**
     * 手机号
     */
    @NotNull
    private String phone;
    /**
     * 新密码
     */
    @NotNull
    private String password;
    /**
     * 修改者
     */
    @NotNull
    private String modifier;

    /**
     * 检测dto参数完整性
     * @return
     */
    public boolean verify(){
        return (null != password) && (null != phone) && (null != modifier);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "ResetPasswordDto{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", modifier='" + modifier + '\'' +
                '}';
    }
}
