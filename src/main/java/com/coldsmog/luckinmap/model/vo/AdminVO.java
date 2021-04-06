package com.coldsmog.luckinmap.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description: 管理员 VO
 * @Author: quanhuan.huang
 * @Date: 2019/10/30 10:31
 */
public class AdminVO implements Serializable {
    private static final long serialVersionUID = 1477962564968557097L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 角色名
     */
    private String roleName;
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
    /**
     * 管理员状态 状态 0：正常 1：禁用
     */
    private Integer status;
    /**
     * 逻辑删除 0：正常 1：逻辑删除
     */
    private Integer deleted;
    /**
     * 注册时间
     */
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Timestamp createTime;
    /**
     * 修改时间
     */
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Timestamp modifyTime;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 修改者
     */
    private String modifier;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "AdminVO{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", status=" + status +
                ", deleted=" + deleted +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", creator='" + creator + '\'' +
                ", modifier='" + modifier + '\'' +
                '}';
    }
}
