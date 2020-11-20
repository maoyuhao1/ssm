package com.bjpowernode.crm.base.bean;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.base.bean
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/17 19:18
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
//分页所有信息对象
public class PaginationVo<T> {
    private int page;//页码
    private int pageSize;//每页显示记录数
    private int totalPages;//总页数
    private long totalRows;//总记录数
    private List<T> queryList;//当前页的数据
    private PageInfo pageInfo;

    public PaginationVo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        this.pageSize = pageInfo.getPageSize();//每页记录数
        this.page = pageInfo.getPageNum();//页码
        this.totalPages = pageInfo.getPages();//总页数
        this.totalRows = pageInfo.getTotal();//总记录数
        this.queryList = pageInfo.getList();//数据
    }

    public PaginationVo() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getQueryList() {
        return queryList;
    }

    public void setQueryList(List<T> queryList) {
        this.queryList = queryList;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
