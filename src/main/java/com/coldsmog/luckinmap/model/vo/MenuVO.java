package com.coldsmog.luckinmap.model.vo;

/**
 * @Description: 穿梭框VO
 * @Author: quanhuan.huang
 * @Date: 2019/11/13 13:50
 */
public class MenuVO {
    /**
     * 数据的唯一性标识
     */
    private Integer key;
    /**
     * 显示文本
     */
    private String label;
    /**
     * 该项数据是否禁止转移
     */
    private static Boolean disabled = false;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    @Override
    public String toString() {
        return "MenuVO{" +
                "key=" + key +
                ", label='" + label + '\'' +
                ", disabled=" + disabled +
                '}';
    }
}
