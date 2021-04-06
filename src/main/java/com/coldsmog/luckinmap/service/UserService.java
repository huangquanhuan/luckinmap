package com.coldsmog.luckinmap.service;

import com.coldsmog.luckinmap.model.dto.PageInfo;
import com.coldsmog.luckinmap.model.dto.ResetPasswordDto;
import com.coldsmog.luckinmap.model.entity.User;
import com.coldsmog.luckinmap.model.vo.AdminVO;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户表，即会员表。(User)表服务接口
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:39
 */
public interface UserService {

    /**
     * 根据对象属性插入
     *
     * @param user 实例对象
     * @return java.lang.Integer
     */
    Integer insertByProperty(User user);

    /**
     * 根据对象属性列表批量插入
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
     * 根据token 获取admin的信息
     *
     * @param token 密令
     * @return 对应admin的信息
     */
    User getByToken(String token);

    /**
     * 根据用户名和密码登录 注销
     *
     * @param username 用户名
     * @param password 密码
     * @return 该记录id, 找不到返回空
     */
    Integer login(String username, String password);

    /**
     * 注销登录
     *
     * @param token 密令
     * @return 注销结果
     */
    boolean logout(String token);

    /**
     * 将admin 的状态换成另一种
     *
     * @param adminId 管理员id
     * @return 数据库影响条数
     */
    Integer updateStatus(Integer adminId);

    /**
     * 获取token
     *
     * @param id admin的id
     * @return 新的jwt格式的token
     */
    String getToken(Integer id);

    /**
     * 刷新token
     *
     * @param token 旧token
     * @return 新token 不允许刷新则返回null
     */
    String refreshToken(String token);


    /**
     * 封装通过token获取user
     *
     * @return 当前的admin用户
     */
    User getAdmin();

    /**
     * 重置密码
     *
     * @param resetPasswordDto 重置密码所需参数
     * @return 更改成功条数
     */
    Integer resetPassword(ResetPasswordDto resetPasswordDto);
}
