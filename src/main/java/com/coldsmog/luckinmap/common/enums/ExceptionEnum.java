package com.coldsmog.luckinmap.common.enums;


/**
 * @Author: yongzhe.dong
 * @Date: 2019/10/30 13:37
 * @Description: 自定义异常枚举
 */
public enum ExceptionEnum {

    /**
     * 用户被禁用
     */
    USER_FORBIDDEN(1001, "用户被禁用"),

    /**
     * 用户不存在
     */
    USER_NOT_EXIST(1002, "用户不存在"),

    /**
     * 用户已存在，无法注册
     */
    USER_IS_EXIST(1003, "用户已存在，无法注册"),

    /**
     * 用户密码错误
     */
    USER_PASSWORD_ERROR(1004, "用户密码错误"),

    /**
     * 验证码不正确
     */
    CAPTCHA_ERROR(1005, "验证码不正确"),

    /**
     * token已过期
     */
    TOKEN_EXPIRED(1006, "token已过期"),

    /**
     * token不存在
     */
    TOKEN_NOT_EXIST(1007, "token不存在"),

    /**
     * refresh_token已过期
     */
    REFRESH_TOKEN_EXPIRED(1008, "refresh_token已过期"),

    /**
     * refresh_token不存在
     */
    REFRESH_TOKEN_NOT_EXIST(1009, "refresh_token不存在"),

    /**
     * 地址信息不完善
     */
    ADDRESS_INFO_INCOMPLETE(1010, "地址信息不完善"),

    /**
     * 参数不完整
     */
    PARAM_INCOMPLETE(1011, "参数不完整"),

    /**
     * 会员信息更新失败
     */
    UPDATE_MEMBER_FAIL(1012, "会员信息更新失败"),

    /**
     * 地址添加失败
     */
    ADD_ADDRESS_FAIL(1013, "地址添加失败"),

    /**
     * 地址更新失败
     */
    UPDATE_ADDRESS_FAIL(1014, "地址更新失败"),

    /**
     * 地址删除失败
     */
    DELETE_ADDRESS_FAIL(1015, "地址删除失败"),

    /**
     * 用户已注销
     */
    USER_DELETED(1016, "用户已注销"),

    //    订单
    /**
     * 每件商品最少加购1件
     */
    CART_PRODUCT_MIN_QUANTITY(3001, "每件商品最少加购1件"),

    /**
     * 每件商品最多加购24件
     */
    CART_PRODUCT_MAN_QUANTITY(3002, "每件商品最多加购24件"),

    /**
     * 加购数量超过门店库存
     */
    CART_PRODUCT_QUANTITY_OUTSTRIP_STOCK(3003, "加购数量超过门店库存"),

    /**
     * 加入购物车失败
     */
    CART_INSERT_ERROR(3004, "加入购物车失败"),

    /**
     * 商品售罄
     */
    CART_PRODUCT_SELL_OUT(3005, "商品售罄"),

    /**
     * 下单参数不合法
     */
    ORDER_PARAM_ILLEGAL(3101, "下单参数不合法"),

    /**
     * 没有选择收货地址
     */
    ORDER_N0_RECEIVING_ADDRESS(3102, "没有选择收货地址"),

    /**
     * 没有选择支付方式
     */
    ORDER_N0_PAY_TYPE(3103, "没有选择支付方式"),

    /**
     * 支付状态已经改变
     */
    ORDER_STATUS_CHANGE(3104, "支付状态已经改变"),

    /**
     * 使用优惠券失败
     */
    ORDER_USE_COUPON_ERROR(3105, "使用优惠券失败"),

    /**
     * 扣库存失败
     */
    ORDER_REDUCE_STOCK_ERROR(3106, "扣库存失败"),

    /**
     * 接口幂等
     */
    REPEAT_SUBMIT_ERROR(3201, "请勿重复提交"),

    //商品
    /**
     * 该商品没有评论
     */
    PRODUCT_NO_COMMENT(4001, "该商品没有评论"),

    /**
     * 没有此规格
     */
    NO_THIS_SKUID(4002,"没有此规格"),
    //    后台
    /**
     * 参数错误
     */
    ADMIN_PARAM_ERROR(5000, "参数错误"),
    /**
     * 数组越界
     */
    ARRAY_OUT_CROSSING(5001, "数组越界"),
    /**
     * 返回对象为空
     */
    NULL_POINTER_EXCEPTION(5002, "返回对象为空"),
    /**
     * 权限不足
     */
    ADMIN_INSUFFICIENT_PERMISSIONS(5003, "权限不足"),
    /**
     * 上传失败
     */
    ADMIN_UPLOAD_FAILED(5004,"上传失败"),
    /**
     * 优惠券
     */
    DISCOUNT_EXCEED_ONE(6001, "折扣优惠券折扣不应大等于10"),
    LOWER_LIMIT_NEQ_ZERO(6002, "折扣优惠券最低使用金额应为0"),
    COUPON_EXIST(6003, "已有相同优惠券存在"),
    COUPON_NOT_EXIST(6004, "优惠券不存在"),
    COUPON_STATUS_ERR(6005, "优惠券状态错误"),
    /**
     * 活动
     */
    ACTIVITY_EXIST(6101, "活动存在"),
    ACTIVITY_NOT_EXIST(6102, "活动不存在"),
    /**
     * 折扣策略
     */
    DISCOUNT_STRATEGY_EXIST(6201, "折扣策略已存在"),
    DISCOUNT_STRATEGY_NOT_EXIST(6202, "折扣策略不存在"),
    /**
     * 会员优惠券
     */
    LAKE_OF_SCORE(6301, "积分不足"),
    MEMBER_COUPON_NOT_EXIST(6302, "优惠券不存在"),
    /**
     * 会员等级
     */
    MEMBER_LEVEL_EXIST(6401, "会员等级已存在"),
    MEMBER_LEVEL_NOT_EXIST(6402, "会员等级不存在"),
    LEVEL_EXIST(6403, "会员等级名称冲突"),
    SCORE_EXIST(6404, "同样积分已有对应的会员等级"),
    /**
     * 营销共用
     */
    PAGE_PARAM_ERR(6901, "分页参数错误"),

    /**
     * 推送商品
     */
    SHOP_PRODUCT_NULL(7001, "没有门店可以推送改商品"),

    /**
     * 商品服务端错误
     */
    SERVER_ERROR(2001,"服务端异常"),

    /**
     * 商品参数类型错误
     */
    PARAM_BIND_ERROR(2002,"参数校验异常：%s"),

    /**
     * 商品添加评论异常
     */
    ADD_COMMENT_ERROR(2003,"添加评论异常"),

    /**
     * 商品添加商品规格异常
     */
    ADD_PRODUCT_SKU_ERROR(2004,"添加商品规格异常"),

    /**
     * 查询商品ProductSkuDTO列表异常
     */
    FIND_PRODUCT_SKU_ERROR(2005,"查询商品ProductSkuDTO列表异常"),

    /**
     * 修改商品信息异常
     */
    UPDATE_PRODUCT_ERROR(2007,"修改商品信息异常"),

    /**
     * 查询商品ProductSkuDTO总数异常
     */
    FIND_PRODUCT_TOTAL_ERROR(2006,"查询商品ProductSkuDTO总数异常");


    /**
     * 状态码
     */
    private int code;

    /**
     * 异常消息
     */
    private String msg;

    /**
     * 构造器
     *
     * @param code code
     * @param msg  异常信息
     */
    private ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public Integer getCode() {
        return this.code;
    }

}
