package com.coldsmog.luckinmap.mapper;
import com.coldsmog.luckinmap.model.entity.Heatdata;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Heatdata)表数据库访问层
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:03
 *
 */
@Mapper
public interface HeatdataMapper{

    /**
     * 根据对象属性插入
     *
     * @param heatdata 实例对象
     * @return java.lang.Integer
     */
    Integer insertByProperty(Heatdata heatdata);

    /**
     * 根据对象列表属性插入
     *
     * @param list 实例列表
     * @return java.lang.Integer
     */
    Integer insertBatchByProperty(List<Heatdata> list);

    /**
     * 根据对象属性带主键更新
     *
     * @param heatdata 实例对象
     * @return java.lang.Integer
     */
    Integer updateByPrimaryKey(Heatdata heatdata);

    /**
    * 根据对象属性带主键列表批量更新
    *
    * @param list 实例对象列表
    * @return java.lang.Integer
    */
    Integer updateBatchByPrimaryKey(List<Heatdata> list);

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
     * @param heatdata 实例对象
     * @return java.lang.Integer
     */
    Integer deleteByProperty(Heatdata heatdata);

    /**
     * 根据主键进行查询
     *
     * @param id 主键
     * @return com.coldsmog.luckinmap.model.entity.Heatdata
     */
    Heatdata selectByPrimaryKey(Integer id);

    /**
     * 根据属性进行查询
     *
     * @param heatdata 实例对象
     * @return java.util.List<com.coldsmog.luckinmap.model.entity.Heatdata>
     */
    List<Heatdata> selectByProperty(Heatdata heatdata);

    /**
     * 根据属性进行查询统计
     *
     * @param heatdata 实例对象
     * @return java.lang.Long
     */
    Long countByProperty(Heatdata heatdata);
}
