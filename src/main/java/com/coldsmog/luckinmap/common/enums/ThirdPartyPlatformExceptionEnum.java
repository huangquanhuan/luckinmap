package com.coldsmog.luckinmap.common.enums;

/**
 * 第三方平台异常枚举
 *
 * @author: wei lin01 (wei.lin01)
 * @date: 2019/11/16 9:49
 */
public enum ThirdPartyPlatformExceptionEnum {
    /**
     * 常见第三方平台异常
     */
    GET_NULL_ACCESS_TOKEN(-10000, "获取到的access token为空"),
    RESULT_ERR(-10001, "调用结果错误");

    /**
     * 类型码
     */
    private Integer code;
    /**
     * 类型
     */
    private String message;

    /**
     * 根据异常码获取异常信息
     *
     * @param code 异常码
     * @return 异常信息
     */
    public static String valueOf(Integer code) {
        for (ThirdPartyPlatformExceptionEnum value : ThirdPartyPlatformExceptionEnum.values()) {
            if (code.equals(value.code)) {
                return value.message;
            }
        }
        return null;
    }

    ThirdPartyPlatformExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
