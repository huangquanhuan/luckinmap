package com.coldsmog.luckinmap.service;

import com.coldsmog.luckinmap.model.entity.Rule;
import java.util.List;

/**
 * (Rule)表服务接口
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:30
 *
 */
public interface RuleService{

    /**
     * 根据对象属性插入
     *
     * @param rule 实例对象
     * @return java.lang.Integer
     */
    Integer insertByProperty(Rule rule);

    /**
     * 根据对象属性列表批量插入
     *
     * @param list 实例列表
     * @return java.lang.Integer
     */
    Integer insertBatchByProperty(List<Rule> list);

    /**
     * 根据对象属性带主键更新
     *
     * @param rule 实例对象
     * @return java.lang.Integer
     */
    Integer updateByPrimaryKey(Rule rule);

    /**
     * 根据对象属性带主键列表批量更新
     *
     * @param list 实例对象列表
     * @return java.lang.Integer
     */
    Integer updateBatchByPrimaryKey(List<Rule> list);

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return java.lang.Integer
     */
    Integer deleteByPrimaryKey(Integer id);

    /**
     * 根据主键列表批量删除
     *
     * @param list 主键列表
     * @return java.lang.Integer
     */
    Integer deleteBatchByPrimaryKey(List<Integer> list);

    /**
     * 根据属性删除
     *
     * @param rule 实例对象
     * @return java.lang.Integer
     */
    Integer deleteByProperty(Rule rule);

    /**
     * 根据主键进行查询
     *
     * @param id 主键
     * @return com.coldsmog.luckinmap.model.entity.Rule
     */
    Rule selectByPrimaryKey(Integer id);

    /**
     * 根据属性进行查询
     *
     * @param rule 实例对象
     * @return java.util.List<com.coldsmog.luckinmap.model.entity.Rule>
     */
    List<Rule> selectByProperty(Rule rule);

    /**
     * 根据属性进行查询统计
     *
     * @param rule 实例对象
     * @return java.lang.Long
     */
    Long countByProperty(Rule rule);

}
