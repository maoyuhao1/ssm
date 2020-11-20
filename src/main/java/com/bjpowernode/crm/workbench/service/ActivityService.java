package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.base.exception.CrmException;
import com.bjpowernode.crm.settings.bean.User;
import com.bjpowernode.crm.workbench.bean.Activity;
import com.bjpowernode.crm.workbench.bean.ActivityQureyVo;
import com.bjpowernode.crm.workbench.bean.ActivityRemark;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.service
 * @Description: java接口作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/17 16:21
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface ActivityService {
    List<Map<String, String>> queryList(ActivityQureyVo activityQureyVo);

    List<User> queryAllOwner();

    void insertActivity(Activity activity) throws CrmException;

    List<Map<String, String>> queryActivityById(String activityId);

    void updateActivity(Activity activity) throws CrmException;

    void deleteActivity(String[] ids) throws CrmException;

    Activity queryActivityDetailById(String id);

    void updateActivityRemark(ActivityRemark activityRemark) throws CrmException;

    void deleteActivityRemark(String id) throws CrmException;

    void saveActivityRemark(ActivityRemark activityRemark) throws CrmException;

    void deleteActivityDetail(String id) throws CrmException;
}
