package com.coldsmog.luckinmap.common.constants;

/**
 * @Description: 管理员模块的常量类
 * 枚举类的类型转化ibatis和mybatis实现不同，设常量类暂时替换
 * @Author: quanhuan.huang
 * @Date: 2019/10/31 09:23
 */
public class AdminConstant {
    /**
     * 正常值
     */
    public static final Integer NORMAL = 0;
    /**
     * 异常值
     */
    public static final Integer OTHER = 1;
    /**
     * 一级菜单的等级值
     */
    public static final Integer FIRST = 1;
    /**
     * 二级菜单等级值
     */
    public static final Integer SECONED = 2;
    /**
     * 数据库root节点的id
     */
    public static final Integer ROOT_ID = 1;

    /**
     * redis 过期时间 单位s
     */
    public static final Integer REDIS_OVER_TIME = 2 * 60 * 60;

    /**
     * redis 命名空间
     */
    public static final String ADMIN_REDIS_SPACE = "admin";
    /**
     * 前端传token的命名
     */
    public static final String TOKEN = "X-Token";

    /**
     * 店长的roleId
     */
    public static final Integer SUPPLE_ID = 16;
}
