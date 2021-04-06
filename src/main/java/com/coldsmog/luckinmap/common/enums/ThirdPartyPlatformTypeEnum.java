package com.coldsmog.luckinmap.common.enums;

/**
 * 第三方平台类型
 *
 * @author: wei lin01 (wei.lin01)
 * @date: 2019/11/16 9:55
 */
public enum ThirdPartyPlatformTypeEnum {
    /**
     * 已使用第三方平台类型
     */
    BAIDU(1, "百度"),
    WECHAT(2, "微信"),
    AMAP(3, "高德");

    /**
     * 类型码
     */
    private Integer code;
    /**
     * 类型
     */
    private String type;

    /**
     * 获取类型码对应类型
     *
     * @param code 类型码
     * @return 类型
     */
    public static String valueOf(Integer code) {
        for (ThirdPartyPlatformTypeEnum value : ThirdPartyPlatformTypeEnum.values()) {
            if (value.code.equals(code)) {
                return value.type;
            }
        }
        return null;
    }

    ThirdPartyPlatformTypeEnum(Integer code, String type) {
        this.code = code;
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
