package com.bjpowernode.crm.workbench.bean;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.bean
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/17 16:06
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Table(name = "tbl_activity")
public class Activity {
    @Id
    private String id;
    private String owner;
    private String name;
    private String start_date;
    private String end_date;
    private String cost;
    private String description;
    private String create_time;
    private String create_by;
    private String edit_time;
    private String edit_by;

    private List<ActivityRemark> activityRemarkList;

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", cost='" + cost + '\'' +
                ", description='" + description + '\'' +
                ", create_time='" + create_time + '\'' +
                ", create_by='" + create_by + '\'' +
                ", edit_time='" + edit_time + '\'' +
                ", edit_by='" + edit_by + '\'' +
                ", activityRemarkList=" + activityRemarkList +
                '}';
    }

    public List<ActivityRemark> getActivityRemarkList() {
        return activityRemarkList;
    }

    public void setActivityRemarkList(List<ActivityRemark> activityRemarkList) {
        this.activityRemarkList = activityRemarkList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getEdit_time() {
        return edit_time;
    }

    public void setEdit_time(String edit_time) {
        this.edit_time = edit_time;
    }

    public String getEdit_by() {
        return edit_by;
    }

    public void setEdit_by(String edit_by) {
        this.edit_by = edit_by;
    }
}
