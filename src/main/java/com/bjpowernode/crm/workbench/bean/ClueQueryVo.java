package com.bjpowernode.crm.workbench.bean;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.bean
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/23 8:50
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class ClueQueryVo {
    private String fullname;
    private String company;
    private String phone;
    private String owner;
    private String mphone;

    @Override
    public String toString() {
        return "ClueQueryVo{" +
                "fullname='" + fullname + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", owner='" + owner + '\'' +
                ", mphone='" + mphone + '\'' +
                '}';
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }
}
