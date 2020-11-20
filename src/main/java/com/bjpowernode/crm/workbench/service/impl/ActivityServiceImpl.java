package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.base.constants.CrmExceptionEnum;
import com.bjpowernode.crm.base.exception.CrmException;
import com.bjpowernode.crm.base.util.DateTimeUtil;
import com.bjpowernode.crm.base.util.UUIDUtil;
import com.bjpowernode.crm.settings.bean.User;
import com.bjpowernode.crm.settings.mapper.UserMapper;
import com.bjpowernode.crm.workbench.bean.Activity;
import com.bjpowernode.crm.workbench.bean.ActivityQureyVo;
import com.bjpowernode.crm.workbench.bean.ActivityRemark;
import com.bjpowernode.crm.workbench.mapper.ActivityMapper;
import com.bjpowernode.crm.workbench.mapper.ActivityRemarkMapper;
import com.bjpowernode.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.service.impl
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/17 16:21
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ActivityRemarkMapper activityRemarkMapper;
    @Override
    public List<Map<String, String>> queryList(ActivityQureyVo activityQureyVo) {
        return activityMapper.queryList(activityQureyVo);
    }

    @Override
    public List<User> queryAllOwner() {
        return userMapper.selectAll();
    }

    @Override
    public void insertActivity(Activity activity) throws CrmException {
        activity.setId(UUIDUtil.getUUID());
        activity.setCreate_time(DateTimeUtil.getSysTime());
        activity.setEdit_time(DateTimeUtil.getSysTime());
        int count = activityMapper.insertSelective(activity);
        if (count == 0){
            throw new CrmException(CrmExceptionEnum.ACTIVITY_CREATE);
        }
    }

    @Override
    public List<Map<String, String>> queryActivityById(String activityId) {
       return activityMapper.queryActivityById(activityId);
    }

    @Override
    public void updateActivity(Activity activity) throws CrmException {
        int count = activityMapper.updateByPrimaryKeySelective(activity);
        if (count == 0){
            throw new CrmException(CrmExceptionEnum.ACTIVITY_CREATE);
        }
    }

    @Override
    public void deleteActivity(String[] ids) throws CrmException {
        for (String id : ids) {
            int count = activityMapper.deleteByPrimaryKey(id);
            if (count == 0){
                throw new CrmException(CrmExceptionEnum.ACTIVITY_DELETE);
            }
        }

    }

    @Override
    public Activity queryActivityDetailById(String id) {
        Activity activity = activityMapper.selectByPrimaryKey(id);
        //根据activity中的owner查询对用的用户
        User user = userMapper.selectByPrimaryKey(activity.getOwner());

        //将用户的姓名设置到owner
        activity.setOwner(user.getName());


        //根据市场活动的主键查询对应的市场活动备注
        //当我们使用tkMapper条件查询的时候,把查询条件拼接到Example中
        Example example = new Example(ActivityRemark.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activity_id",id);
        List<ActivityRemark> activityRemarks = activityRemarkMapper.selectByExample(example);
        activity.setActivityRemarkList(activityRemarks);
        return activity;
    }

    @Override
    public void updateActivityRemark(ActivityRemark activityRemark) throws CrmException {
        int count = activityRemarkMapper.updateByPrimaryKeySelective(activityRemark);
        if (count == 0){
            throw new CrmException(CrmExceptionEnum.ACTIVITY_REMARK_UPDATE);
        }
    }

    @Override
    public void deleteActivityRemark(String id) throws CrmException {
        int count = activityRemarkMapper.deleteByPrimaryKey(id);
        if (count == 0){
            throw new CrmException(CrmExceptionEnum.ACTIVITY_REMARK_DELETE);
        }
    }

    @Override
    public void saveActivityRemark(ActivityRemark activityRemark) throws CrmException {
        int count = activityRemarkMapper.insertSelective(activityRemark);
        if (count == 0){
            throw new CrmException(CrmExceptionEnum.ACTIVITY_REMARK_SAVE);
        }
    }

    @Override
    public void deleteActivityDetail(String id) throws CrmException {
        int count = activityMapper.deleteByPrimaryKey(id);
        if (count == 0){
            throw new CrmException(CrmExceptionEnum.ACTIVITY_DELETE);
        }
        Example example  = new Example(ActivityRemark.class);
        example.createCriteria().andEqualTo("activity_id",id);
        activityRemarkMapper.deleteByExample(example);
    }
}
