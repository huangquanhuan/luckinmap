package com.coldsmog.luckinmap.model.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yongzhe.dong
 * @Date: 2019/10/25 14:16
 * @Description: 分页查询工具类
 */
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 3571732864695705773L;
    /**
     * 查询到的数据集合
     */
    private List<T> list;
    /**
     * 总数
     */
    private Long total;
    /**
     * 当前页
     */
    private Integer pageNum = 1;
    /**
     * 每页显示的数量
     */
    private Integer pageSize = 10;

    public PageInfo() {
    }

    public PageInfo(List<T> list, Long total, Integer pageNum) {
        this.list = list;
        this.total = total;
        this.pageNum = pageNum;
    }

    public PageInfo(List<T> list, Long total, Integer pageNum, Integer pageSize) {
        this.list = list;
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "list=" + list +
                ", total=" + total +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}

