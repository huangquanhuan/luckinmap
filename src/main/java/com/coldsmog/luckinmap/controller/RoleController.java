package com.coldsmog.luckinmap.controller;


import com.coldsmog.luckinmap.model.dto.Result;
import com.coldsmog.luckinmap.model.entity.Role;
import com.coldsmog.luckinmap.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 角色表，保存角色名和对应权限等级(Role)表控制层
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:26
 */
@Controller
@RequestMapping("/role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 根据对象属性插入
     *
     * @param role 实例对象
     * @return java.lang.Integer
     */
    Result insertRole(Role role) {
        return Result.success("true");
    }


    /**
     * 根据对象属性带主键更新
     *
     * @param role 实例对象
     * @return java.lang.Integer
     */
    Result updateRole(Role role) {
        return Result.success("true");
    }

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return java.lang.Integer
     */
    Result deleteRole(Integer id) {
        return Result.success("true");
    }

    /**
     * 根据主键列表批量删除
     *
     * @param list 主键列表
     * @return java.lang.Integer
     */
    Result deleteBatchRole(List<Integer> list) {
        return Result.success("true");
    }

    /**
     * 根据属性删除
     *
     * @param role 实例对象
     * @return java.lang.Integer
     */
    Result deleteRole(Role role) {
        return Result.success("true");
    }

    /**
     * 根据主键进行查询
     *
     * @param id 主键
     * @return com.coldsmog.luckinmap.model.entity.Role
     */
    Result selectRole(Integer id) {
        return Result.success("true");
    }

}
