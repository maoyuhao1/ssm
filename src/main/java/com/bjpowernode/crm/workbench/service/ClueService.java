package com.bjpowernode.crm.workbench.service;

import com.bjpowernode.crm.workbench.bean.Activity;
import com.bjpowernode.crm.workbench.bean.Clue;

import java.util.List;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.service
 * @Description: java接口作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/21 20:03
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface ClueService {
    List<Clue> queryList();

    Clue queryClueDetailById(String id);

    List<Activity> queryClueActivity(String clueId);

    List<Activity> queryActivityExculdeNow(String clueId, String activityName);
}
