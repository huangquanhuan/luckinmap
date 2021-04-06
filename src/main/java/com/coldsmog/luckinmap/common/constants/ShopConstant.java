package com.coldsmog.luckinmap.common.constants;

/**
 * @Description: admin的shop模块的常量类
 * 枚举类的类型转化ibatis和mybatis实现不同，设常量类暂时替换
 * @Author: haung.zhao
 * @Date: 2019/11/08 13:54
 */
public class ShopConstant {
    /**
     * 门店删除状态对应值
     */
    public static final Boolean SHOP_IN_DELETE = true;

    /**
     * 最佳匹配的商品id不存在时的id
     */
    public static final Integer BEST_MATCH_ID = -1;

    /**
     * 分页返回结果为0
     */
    public static final Integer RETURN_DATA_NUMBER = 0;

    /**
     * 分页查询Total返回结果为0的判断条件
     */
    public static final Long RETURN_DATA_TOTAL = 0L;


}
