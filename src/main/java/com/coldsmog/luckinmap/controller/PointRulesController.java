package com.coldsmog.luckinmap.controller;


import com.coldsmog.luckinmap.model.dto.Result;
import com.coldsmog.luckinmap.model.entity.PointRules;
import com.coldsmog.luckinmap.service.PointRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * (PointRules)表控制层
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:16
 */
@Controller
@RequestMapping("/pointRules/")
public class PointRulesController {

    @Autowired
    private PointRulesService pointRulesService;

    /**
     * 根据对象属性插入
     *
     * @param pointRules 实例对象
     * @return java.lang.Integer
     */
    @PostMapping("/insertPointRules")
    Result insertPointRules(PointRules pointRules) {
        return Result.success("true");
    }

    /**
     * 根据对象属性列表批量插入
     *
     * @param list 实例列表
     * @return java.lang.Integer
     */
    @PostMapping("/insertBatchPointRules")
    Result insertBatchPointRules(List<PointRules> list) {
        return Result.success("true");
    }

    /**
     * 根据对象属性带主键更新
     *
     * @param pointRules 实例对象
     * @return java.lang.Integer
     */
    @PostMapping("/updatePointRules")
    Result updatePointRules(PointRules pointRules) {
        return Result.success("true");
    }

    /**
     * 根据对象属性带主键列表批量更新
     *
     * @param list 实例对象列表
     * @return java.lang.Integer
     */
    @GetMapping("/updateBatchPointRules")
    Result updateBatchPointRules(List<PointRules> list) {
        return Result.success("true");
    }

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return java.lang.Integer
     */
    @PostMapping("/deletePointRules")
    Result deletePointRules(Integer id) {
        return Result.success("true");
    }

    /**
     * 根据主键列表批量删除
     *
     * @param list 主键列表
     * @return java.lang.Integer
     */
    @PostMapping("/deleteBatchPointRules")
    Result deleteBatchPointRules(List<Integer> list) {
        return Result.success("true");
    }

    /**
     * 根据属性删除
     *
     * @param pointRules 实例对象
     * @return java.lang.Integer
     */
    @PostMapping("/deletePointRules")
    Result deletePointRules(PointRules pointRules) {
        return Result.success("true");
    }

    /**
     * 根据主键进行查询
     *
     * @param id 主键
     * @return com.coldsmog.luckinmap.model.entity.PointRules
     */
    @GetMapping("/selectPointRules")
    Result selectPointRules(Integer id) {
        return Result.success("true");
    }

    /**
     * 根据属性进行查询
     *
     * @param pointRules 实例对象
     * @return java.util.List<com.coldsmog.luckinmap.model.entity.PointRules>
     */
    @GetMapping("/selectPointRules")
    Result selectPointRules(PointRules pointRules) {
        return Result.success("true");
    }

    /**
     * 根据属性进行查询统计
     *
     * @param pointRules 实例对象
     * @return java.lang.Long
     */
    @GetMapping("/countPointRules")
    Result countPointRules(PointRules pointRules) {
        return Result.success("true");
    }
}
