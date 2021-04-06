package com.coldsmog.luckinmap.controller;


import com.coldsmog.luckinmap.model.dto.Result;
import com.coldsmog.luckinmap.model.entity.Heatdata;
import com.coldsmog.luckinmap.service.HeatdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * (Heatdata)表控制层
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:03
 */
@Controller
@RequestMapping("/heatdata/")
public class HeatdataController {

    @Autowired
    private HeatdataService heatdataService;

    /**
     * 获取热力图数据
     *
     * @param datetime 时间
     * @param hour     粒度
     * @return 热力图数据列表
     */
    @GetMapping("/getHeatDataByTime")
    public Result getHeatDataByTime(String datetime, Integer id,String hour) {
        return Result.success("true");
    }

    /**
     * 获取 区域列表
     *
     * @param province 省份名
     * @param city     城市名
     * @return 区域列表
     */
    @GetMapping("/getRegion")
    public Result getRegion(String province, String city) {
        return Result.success("true");
    }

    /**
     * 爬取所有城市
     *
     * @param province 省份名
     * @return 城市列表
     */
    @GetMapping("/getCity")
    public Result getCity(String province) {
        return Result.success("true");
    }

    /**
     * 获取所有省份
     *
     * @return 省份列表
     */
    @GetMapping("/getProvince")
    public Result getProvince() {
        return Result.success("true");
    }

    /**
     * 根据对象属性插入
     *
     * @param heatdata 实例对象
     * @return java.lang.Integer
     */
    @PostMapping("/insertHeatdata")
    Result insertHeatdata(Heatdata heatdata) {
        return Result.success("true");
    }

    /**
     * 根据对象属性列表批量插入
     *
     * @param list 实例列表
     * @return java.lang.Integer
     */
    @PostMapping("/insertBatchHeatdata")
    Result insertBatchHeatdata(List<Heatdata> list) {
        return Result.success("true");
    }

    /**
     * 根据对象属性带主键更新
     *
     * @param heatdata 实例对象
     * @return java.lang.Integer
     */
    @PostMapping("/updateHeatdata")
    Result updateHeatdata(Heatdata heatdata) {
        return Result.success("true");
    }

    /**
     * 根据对象属性带主键列表批量更新
     *
     * @param list 实例对象列表
     * @return java.lang.Integer
     */
    @PostMapping("/updateBatchHeatdata")
    Result updateBatchHeatdata(List<Heatdata> list) {
        return Result.success("true");
    }

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return java.lang.Integer
     */
    @PostMapping("/deleteHeatdata")
    Result deleteHeatdata(Integer id) {
        return Result.success("true");
    }

    /**
     * 根据主键列表批量删除
     *
     * @param list 主键列表
     * @return java.lang.Integer
     */
    @PostMapping("/deleteBatchHeatdata")
    Result deleteBatchHeatdata(List<Integer> list) {
        return Result.success("true");
    }

    /**
     * 根据属性删除
     *
     * @param heatdata 实例对象
     * @return java.lang.Integer
     */
    @PostMapping("/deleteHeatdata")
    Result deleteHeatdata(Heatdata heatdata) {
        return Result.success("true");
    }

    /**
     * 根据主键进行查询
     *
     * @param id 主键
     * @return com.coldsmog.luckinmap.model.entity.Heatdata
     */
    @GetMapping("/selectHeatdata")
    Result selectHeatdata(Integer id) {
        return Result.success("true");
    }

    /**
     * 根据属性进行查询
     *
     * @param heatdata 实例对象
     * @return java.util.List<com.coldsmog.luckinmap.model.entity.Heatdata>
     */
    @GetMapping("/selectHeatdata")
    Result selectHeatdata(Heatdata heatdata) {
        return Result.success("true");
    }

    /**
     * 根据属性进行查询统计
     *
     * @param heatdata 实例对象
     * @return java.lang.Long
     */
    @GetMapping("/countHeatdata")
    Result countHeatdata(Heatdata heatdata) {
        return Result.success("true");
    }

}
