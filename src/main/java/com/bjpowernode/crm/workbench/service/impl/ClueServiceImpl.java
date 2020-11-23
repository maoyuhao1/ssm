package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.settings.bean.User;
import com.bjpowernode.crm.settings.mapper.UserMapper;
import com.bjpowernode.crm.workbench.bean.Activity;
import com.bjpowernode.crm.workbench.bean.Clue;
import com.bjpowernode.crm.workbench.bean.ClueActivityRelation;
import com.bjpowernode.crm.workbench.mapper.ActivityMapper;
import com.bjpowernode.crm.workbench.mapper.ClueActivityRelationMapper;
import com.bjpowernode.crm.workbench.mapper.ClueMapper;
import com.bjpowernode.crm.workbench.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.service.impl
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/21 20:04
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service
public class ClueServiceImpl implements ClueService {
    @Autowired
    private ClueMapper clueMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ClueActivityRelationMapper clueActivityRelationMapper;

    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public List<Clue> queryList() {
        return clueMapper.queryList();
    }

    @Override
    public Clue queryClueDetailById(String id) {
        Clue clue = clueMapper.selectByPrimaryKey(id);
        User user = userMapper.selectByPrimaryKey(clue.getOwner());
        clue.setOwner(user.getName());
        return clue;
    }

    @Override
    public List<Activity> queryClueActivity(String clueId) {
        Example example = new Example(ClueActivityRelation.class);
        example.createCriteria().andEqualTo("clueId",clueId);
        List<ClueActivityRelation> clueActivityRelations = clueActivityRelationMapper.selectByExample(example);
        List<Activity> activityList = new ArrayList<>();
        for (ClueActivityRelation clueActivityRelation : clueActivityRelations) {
            Activity activity = activityMapper.selectByPrimaryKey(clueActivityRelation.getActivityId());
            User user = userMapper.selectByPrimaryKey(activity.getOwner());
            activity.setOwner(user.getName());
            activityList.add(activity);
        }
        return activityList;
    }

    @Override
    public List<Activity> queryActivityExculdeNow(String clueId, String activityName) {
        return activityMapper.queryActivityExculdeNow(clueId,activityName);
    }
}
