package com.bjpowernode.crm.workbench.bean;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.bean
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/17 20:23
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */

public class ActivityQureyVo {
    private String name;
    private String owner;
    private String start_date;
    private String end_date;

    @Override
    public String toString() {
        return "ActivityQureyVo{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
