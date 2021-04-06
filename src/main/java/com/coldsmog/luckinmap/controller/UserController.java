package com.coldsmog.luckinmap.controller;


import com.coldsmog.luckinmap.model.ao.*;
import com.coldsmog.luckinmap.model.dto.ResetPasswordDto;
import com.coldsmog.luckinmap.model.dto.Result;
import com.coldsmog.luckinmap.common.enums.ExceptionEnum;
import com.coldsmog.luckinmap.common.utils.Md5Util;
import com.coldsmog.luckinmap.model.vo.AdminVO;
import com.coldsmog.luckinmap.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户表，即会员表。(User)表控制层
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:39
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param loginAO 登录AO
     * @return token
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginAO loginAO) {
        return Result.success("true");
    }

    /**
     * 注册
     *
     * @param loginAO 注册信息
     * @return token
     */
    @PostMapping("/register")
    public Result register(@RequestBody LoginAO loginAO) {
        return Result.success("true");
    }

    /**
     * 根据token 获取用户信息
     * * @param token 密令
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public Result getInfo(String token) {
        return Result.success("true");
    }

    /**
     * 用户注销
     *
     * @return 注销结果
     */
    @PostMapping("/logout")
    public Result logout() {
        return Result.success("true");
    }

    /**
     * 刷新
     *
     * @return 新token | 失败
     */
    @PostMapping("/freshToken")
    public Result freshToken() {
        return Result.success("true");
    }

    /**
     * 更新状态
     *
     * @param userId user的id
     * @return 更改结果条数
     */
    @PostMapping("/updateStatus/id/{id}")
    public Result updateStatus(@PathVariable("id") Integer userId) {
        return Result.success("true");
    }

    /**
     * 根据id获取user详情
     *
     * @param id user的id
     * @return userVO | 失败
     */
    @GetMapping("getById")
    public Result getById(@RequestParam Integer id) {
        return Result.success("true");
    }

    /**
     * 根据对象属性插入
     *
     * @param entity user
     * @return 带id的user
     */
    @PostMapping("save")
    public Result save(@RequestBody AdminSaveAO entity) {
        return Result.success("true");
    }

    /**
     * 根据对象属性更新
     *
     * @param entity user
     * @return 影响结果条数
     */
    @PostMapping("update")
    public Result update(@RequestBody AdminUpdateAO entity) {
        return Result.success("true");
    }

    /**
     * 根据对照主键删除
     *
     * @param id user主键
     * @return 影响结果条数
     */
    @PostMapping("deleteById/id/{id}")
    public Result deleteById(@PathVariable Integer id) {
        return Result.success("true");
    }

    /**
     * 分页查询
     *
     * @return 分页后的list
     */
    @GetMapping("getPageList")
    public Result getPageList(@Valid AdminPageAO userPageAO) {
        return Result.success("true");
    }

    /**
     * 根据id列表返回对应的用户列表
     *
     * @param ids id列表
     * @return username列表
     */
    @GetMapping("/getUserByIds")
    public Result getUserByIds(@RequestParam List<Integer> ids) {
        return Result.success("true");
    }

    /**
     * 后台管理员密码更新
     *
     * @param userUpdatePasswordAO 后台管理员密码更新
     * @return 更新结果
     */
    @PutMapping("/updatePassword")
    @ApiOperation(value = "后台管理员密码更新", notes = "后台管理员密码更新")
    public Result updatePassword(@Valid @RequestBody AdminUpdatePasswordAO userUpdatePasswordAO) {
        return Result.success("true");
    }

}
