package com.coldsmog.luckinmap.controller;


import com.coldsmog.luckinmap.model.dto.Result;
import com.coldsmog.luckinmap.model.entity.Point;
import com.coldsmog.luckinmap.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * (Point)表控制层
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:12
 */
@Controller
@RequestMapping("/point/")
public class PointController {

    @Autowired
    private PointService pointService;

    /**
     * 根据对象属性插入
     *
     * @param point 实例对象
     * @return java.lang.Integer
     */
    @PostMapping("/insertPoint")
    Result insertPoint(Point point) {
        return Result.success("true");
    }

    /**
     * 根据对象属性列表批量插入
     *
     * @param list 实例列表
     * @return java.lang.Integer
     */
    @PostMapping("/insertBatchPoint")
    Result insertBatchPoint(List<Point> list) {
        return Result.success("true");
    }

    /**
     * 根据对象属性带主键更新
     *
     * @param point 实例对象
     * @return java.lang.Integer
     */
    @PostMapping("/updatePoint")
    Result updatePoint(Point point) {
        return Result.success("true");
    }

    /**
     * 根据对象属性带主键列表批量更新
     *
     * @param list 实例对象列表
     * @return java.lang.Integer
     */
    @PostMapping("/updateBatchPoint")
    Result updateBatchPoint(List<Point> list) {
        return Result.success("true");
    }

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return java.lang.Integer
     */
    @PostMapping("/deletePoint")
    Result deletePoint(Integer id) {
        return Result.success("true");
    }

    /**
     * 根据主键列表批量删除
     *
     * @param list 主键列表
     * @return java.lang.Integer
     */
    @PostMapping("/deleteBatchPoint")
    Result deleteBatchPoint(List<Integer> list) {
        return Result.success("true");
    }

    /**
     * 根据属性删除
     *
     * @param point 实例对象
     * @return java.lang.Integer
     */
    @PostMapping("/deletePoint")
    Result deletePoint(Point point) {
        return Result.success("true");
    }

    /**
     * 根据主键进行查询
     *
     * @param id 主键
     * @return com.coldsmog.luckinmap.model.entity.Point
     */
    @GetMapping("/selectPoint")
    Result selectPoint(Integer id) {
        return Result.success("true");
    }

    /**
     * 根据属性进行查询
     *
     * @param point 实例对象
     * @return java.util.List<com.coldsmog.luckinmap.model.entity.Point>
     */
    @GetMapping("/selectPoint")
    Result selectPoint(Point point) {
        return Result.success("true");
    }

    /**
     * 根据属性进行查询统计 推荐
     *
     * @param point 实例对象
     * @return java.lang.Long
     */
    @GetMapping("/countPoint")
    Result countPoint(Point point) {
        return Result.success("true");
    }

    /**
     * 获取推荐点 审核
     *
     * @param regionId 区域id
     * @return point 列表
     */
    @GetMapping("/getRecommend")
    Result getRecommend(Integer regionId) {
        return Result.success("true");
    }

}
