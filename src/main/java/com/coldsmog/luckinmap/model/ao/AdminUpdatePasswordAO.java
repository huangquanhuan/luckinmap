package com.coldsmog.luckinmap.model.ao;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Description: 忘记密码AO
 * @Author: mingfeng.zhu  mingfeng.zhu
 * @Date: 2019/11/19 11:02
 */
public class AdminUpdatePasswordAO implements Serializable {
    private static final long serialVersionUID = -5587898392783199008L;
    /**
     * 电话号码
     */
    @NotNull
    private String phone;
    /**
     * 新密码
     */
    @NotNull
    private String password;
    /**
     * 验证码
     */
    @NotNull
    private String captcha;
    /**
     * 修改者
     */
    private String modifier;

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

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "AdminUpdatePasswordAO{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", captcha='" + captcha + '\'' +
                ", modifier='" + modifier + '\'' +
                '}';
    }
}
