package com.coldsmog.luckinmap.common.constants;

import java.math.BigDecimal;

/**
 * @Description: admin的product模块的常量类
 * 枚举类的类型转化ibatis和mybatis实现不同，设常量类暂时替换
 * @Author: haung.zhao
 * @Date: 2019/11/07 14:20
 */
public class ProductConstant {
    /**
     * 插入商品分类失败返回值
     */
    public static final Integer ADD_CATEGORY_FAIL = 0;

    /**
     * 插入商品失败返回值
     */
    public static final Integer ADD_PRODUCT_FAIL = 0;

    /**
     * 查出来商品数是0条
     */
    public static final Integer PRODUCT_ZERO  = 0;

    /**
     * 更新库存返回结果条数
     */
    public static final Integer UPDATE_NUMBER  = 0;

    /**
     * 促销价的使用
     */
    public static final BigDecimal DIVIDE_VALUE = new BigDecimal("10");

    /**
     * 价格保留位数
     */
    public static final Integer VALUE_POINT_NUMBER = 2;

    /**
     * 分页查询Total返回结果为0的判断条件
     */
    public static final Long RETURN_DATA_TOTAL = 0L;
}
