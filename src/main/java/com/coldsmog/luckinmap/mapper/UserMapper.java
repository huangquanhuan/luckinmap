package com.coldsmog.luckinmap.mapper;

import com.coldsmog.luckinmap.model.dto.ResetPasswordDto;
import com.coldsmog.luckinmap.model.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表，即会员表。(User)表数据库访问层
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:39
 */
@Mapper
public interface UserMapper {

    /**
     * 根据对象属性插入
     *
     * @param user 实例对象
     * @return java.lang.Integer
     */
    Integer insertByProperty(User user);

    /**
     * 根据对象列表属性插入
     *
     * @param list 实例列表
     * @return java.lang.Integer
     */
    Integer insertBatchByProperty(List<User> list);

    /**
     * 根据对象属性带主键更新
     *
     * @param user 实例对象
     * @return java.lang.Integer
     */
    Integer updateByPrimaryKey(User user);

    /**
     * 根据对象属性带主键列表批量更新
     *
     * @param list 实例对象列表
     * @return java.lang.Integer
     */
    Integer updateBatchByPrimaryKey(List<User> list);

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
     * @param user 实例对象
     * @return java.lang.Integer
     */
    Integer deleteByProperty(User user);

    /**
     * 根据主键进行查询
     *
     * @param id 主键
     * @return com.coldsmog.luckinmap.model.entity.User
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 根据属性进行查询
     *
     * @param user 实例对象
     * @return java.util.List<com.coldsmog.luckinmap.model.entity.User>
     */
    List<User> selectByProperty(User user);

    /**
     * 根据属性进行查询统计
     *
     * @param user 实例对象
     * @return java.lang.Long
     */
    Long countByProperty(User user);

    /**
     * 将admin 的状态换成另一种
     *
     * @param adminId 管理员id
     * @return 数据库影响条数
     */
    Integer updateStatus(Integer adminId);

    /**
     * 根据手机号修改密码
     *
     * @param resetPasswordDto 修改密码dto
     * @return 影响结果条数
     */
    Integer resetPassword(ResetPasswordDto resetPasswordDto);
}
