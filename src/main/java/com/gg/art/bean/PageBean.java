package com.gg.art.bean;/**
 * Created by chenhu on 2018/6/13.
 */

/**
 * @Auther: chenhu
 * @Date: 2018/6/13 09:17
 * @Description:
 */
public class PageBean {
    private int pageNum;
    private int pageSize;
    private Long total;

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
