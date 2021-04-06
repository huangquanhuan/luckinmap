package com.coldsmog.luckinmap.controller;


import com.coldsmog.luckinmap.model.dto.Result;
import com.coldsmog.luckinmap.model.entity.Rule;
import com.coldsmog.luckinmap.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * (Rule)表控制层
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:30
 */
@Controller
@RequestMapping("/rule/")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    /**
     * 根据对象属性插入
     *
     * @param rule 实例对象
     * @return java.lang.Integer
     */
    @PostMapping("/insertRule")
    Result insertRule(Rule rule) {
        return Result.success("true");
    }

    /**
     * 根据对象属性列表批量插入
     *
     * @param list 实例列表
     * @return java.lang.Integer
     */
    @PostMapping("/insertBatchRule")
    Result insertBatchRule(List<Rule> list) {
        return Result.success("true");
    }

    /**
     * 根据对象属性带主键更新
     *
     * @param rule 实例对象
     * @return java.lang.Integer
     */
    @PostMapping("/updateRule")
    Result updateRule(Rule rule) {
        return Result.success("true");
    }

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return java.lang.Integer
     */
    @PostMapping("/deleteRule")
    Result deleteRule(Integer id) {
        return Result.success("true");
    }

    /**
     * 根据主键列表批量删除
     *
     * @param list 主键列表
     * @return java.lang.Integer
     */
    @PostMapping("/deleteBatchRule")
    Result deleteBatchRule(List<Integer> list) {
        return Result.success("true");
    }

    /**
     * 根据属性删除
     *
     * @param rule 实例对象
     * @return java.lang.Integer
     */
    @PostMapping("/deleteRule")
    Result deleteRule(Rule rule) {
        return Result.success("true");
    }

    /**
     * 根据主键进行查询
     *
     * @param id 主键
     * @return com.coldsmog.luckinmap.model.entity.Rule
     */
    @GetMapping("/selectRule")
    Result selectRule(Integer id) {
        return Result.success("true");
    }

    /**
     * 根据属性进行查询
     *
     * @param rule 实例对象
     * @return java.util.List<com.coldsmog.luckinmap.model.entity.Rule>
     */
    @GetMapping("/selectRule")
    Result selectRule(Rule rule) {
        return Result.success("true");
    }

    /**
     * 根据属性进行查询统计
     *
     * @param rule 实例对象
     * @return java.lang.Long
     */
    @GetMapping("/countRule")
    Result countRule(Rule rule) {
        return Result.success("true");
    }
}
