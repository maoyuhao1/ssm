package com.bjpowernode.crm.workbench.bean;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.bean
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/17 17:26
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Table(name = "tbl_activity_remark")
public class ActivityRemark {
    @Id
    private String id;
    private String note_content;
    private String create_time;
    private String create_by;
    private String edit_time;
    private String edit_by;
    private String edit_flag;
    private String activity_id;

    @Override
    public String toString() {
        return "ActivityRemark{" +
                "id='" + id + '\'' +
                ", note_content='" + note_content + '\'' +
                ", create_time='" + create_time + '\'' +
                ", create_by='" + create_by + '\'' +
                ", edit_time='" + edit_time + '\'' +
                ", edit_by='" + edit_by + '\'' +
                ", edit_flag='" + edit_flag + '\'' +
                ", activity_id='" + activity_id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote_content() {
        return note_content;
    }

    public void setNote_content(String note_content) {
        this.note_content = note_content;
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

    public String getEdit_flag() {
        return edit_flag;
    }

    public void setEdit_flag(String edit_flag) {
        this.edit_flag = edit_flag;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
    }
}
