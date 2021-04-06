package com.coldsmog.luckinmap.model.ao;

import javax.validation.constraints.NotNull;

/**
 * @Description: 对页数的转化
 * @Author: quanhuan.huang
 * @Date: 2019/11/4 13:05
 */
public class BasePageAO {
    /**
     * 当前页数
     */
    @NotNull
    protected Integer pageNum;
    /**
     * 当前页的容量
     */
    @NotNull
    protected Integer pageSize;

    /**
     * 转换为起始下标
     *
     * @return
     */
    public Integer getStart() {
        return pageNum * pageSize - pageSize;
    }

    /**
     * 转换为结束下标
     *
     * @return
     */
    public Integer getEnd() {
        return pageNum * pageSize;
    }


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "BasePageAO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
