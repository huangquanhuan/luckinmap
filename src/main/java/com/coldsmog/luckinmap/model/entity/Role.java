package com.coldsmog.luckinmap.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.io.Serializable;

/**
 * 角色表，保存角色名和对应权限等级(Role)表实体类
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:26
 *
 */
@Entity
@Table
public class Role implements Serializable{
    private static final long serialVersionUID = 772465552435357337L;

    @Id
    @GeneratedValue
    private Integer id;
        /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色权限等级：1会员，2商家，3系统管理员
     */
    private Integer roleGrant;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改者
     */
    private String mender;


    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleGrant() {
        return roleGrant;
    }

    public void setRoleGrant(Integer roleGrant) {
        this.roleGrant = roleGrant;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMender() {
        return mender;
    }

    public void setMender(String mender) {
        this.mender = mender;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }


}
