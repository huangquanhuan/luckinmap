package com.coldsmog.luckinmap.mapper;
import com.coldsmog.luckinmap.model.entity.PointRules;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (PointRules)表数据库访问层
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:16
 *
 */
@Mapper
public interface PointRulesMapper{

    /**
     * 根据对象属性插入
     *
     * @param pointRules 实例对象
     * @return java.lang.Integer
     */
    Integer insertByProperty(PointRules pointRules);

    /**
     * 根据对象列表属性插入
     *
     * @param list 实例列表
     * @return java.lang.Integer
     */
    Integer insertBatchByProperty(List<PointRules> list);

    /**
     * 根据对象属性带主键更新
     *
     * @param pointRules 实例对象
     * @return java.lang.Integer
     */
    Integer updateByPrimaryKey(PointRules pointRules);

    /**
    * 根据对象属性带主键列表批量更新
    *
    * @param list 实例对象列表
    * @return java.lang.Integer
    */
    Integer updateBatchByPrimaryKey(List<PointRules> list);

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
     * @param pointRules 实例对象
     * @return java.lang.Integer
     */
    Integer deleteByProperty(PointRules pointRules);

    /**
     * 根据主键进行查询
     *
     * @param id 主键
     * @return com.coldsmog.luckinmap.model.entity.PointRules
     */
    PointRules selectByPrimaryKey(Integer id);

    /**
     * 根据属性进行查询
     *
     * @param pointRules 实例对象
     * @return java.util.List<com.coldsmog.luckinmap.model.entity.PointRules>
     */
    List<PointRules> selectByProperty(PointRules pointRules);

    /**
     * 根据属性进行查询统计
     *
     * @param pointRules 实例对象
     * @return java.lang.Long
     */
    Long countByProperty(PointRules pointRules);
}
