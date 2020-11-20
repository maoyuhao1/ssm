package com.bjpowernode.crm.base.bean;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.base.bean
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/18 9:05
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */

public class ResultVo {
    private boolean isOK;
    private String mess;

    @Override
    public String toString() {
        return "ResultVo{" +
                "isOK=" + isOK +
                ", mess='" + mess + '\'' +
                '}';
    }

    public boolean isOK() {
        return isOK;
    }

    public void setOK(boolean OK) {
        isOK = OK;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
