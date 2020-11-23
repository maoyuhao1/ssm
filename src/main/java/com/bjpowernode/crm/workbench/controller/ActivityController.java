package com.bjpowernode.crm.workbench.controller;

import com.bjpowernode.crm.base.bean.PaginationVo;
import com.bjpowernode.crm.base.bean.ResultVo;
import com.bjpowernode.crm.base.constants.CrmConstants;
import com.bjpowernode.crm.base.exception.CrmException;
import com.bjpowernode.crm.base.util.DateTimeUtil;
import com.bjpowernode.crm.base.util.UUIDUtil;
import com.bjpowernode.crm.settings.bean.User;
import com.bjpowernode.crm.workbench.bean.Activity;
import com.bjpowernode.crm.workbench.bean.ActivityQureyVo;
import com.bjpowernode.crm.workbench.bean.ActivityRemark;
import com.bjpowernode.crm.workbench.service.ActivityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.controller
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/17 16:20
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("/workbench/activity/queryList")
    @ResponseBody
    public PaginationVo queryList(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "2") int pageSize,
                                  ActivityQureyVo activityQureyVo){
        PageHelper.startPage(page,pageSize);
        List<Map<String, String>> queryList = activityService.queryList(activityQureyVo);
        PageInfo<Map<String, String>> pageInfo = new PageInfo<>(queryList);
        PaginationVo paginationVo = new PaginationVo(pageInfo);
            return paginationVo;
    }


    @RequestMapping("/workbench/activity/queryAllOwner")
    @ResponseBody
    public List<User> queryAllOwner(){
        return activityService.queryAllOwner();
    }



    @RequestMapping("/workbench/activity/createActivity")
    @ResponseBody
    public ResultVo createActivity(Model model, Activity activity, HttpSession session) {
        ResultVo resultVo = new ResultVo();
        User user = (User) session.getAttribute(CrmConstants.LOGIN_USER);

        activity.setCreate_by(user.getName());
        activity.setEdit_by(user.getName());
        try {
            activityService.insertActivity(activity);
        } catch (CrmException e) {
            resultVo.setOK(false);
            resultVo.setMess(e.getMessage());
            return resultVo;
        }

        resultVo.setOK(true);
        resultVo.setMess("创建成功");
        return resultVo;
    }


    @RequestMapping("/workbench/activity/queryActivityById")
    @ResponseBody
    public List<Map<String,String>> queryActivityById(String activityId) {

        return activityService.queryActivityById(activityId);
    }


    @RequestMapping("/workbench/activity/updateActivity")
    @ResponseBody
    public ResultVo updateActivity(Activity activity) {
        ResultVo resultVo = new ResultVo();
        activity.setEdit_time(DateTimeUtil.getSysTime());
        try {
            activityService.updateActivity(activity);
        } catch (CrmException e) {
            resultVo.setOK(false);
            resultVo.setMess(e.getMessage());
            return resultVo;
        }

        resultVo.setOK(true);
        resultVo.setMess("更新成功");
        return resultVo;
    }


    @RequestMapping("/workbench/activity/deleteActivity")
    @ResponseBody
    public ResultVo deleteActivity(String[] ids) {
        ResultVo resultVo = new ResultVo();
        try {
            activityService.deleteActivity(ids);
        } catch (CrmException e) {
            resultVo.setOK(false);
            resultVo.setMess(e.getMessage());
            return resultVo;
        }
        resultVo.setOK(true);
        resultVo.setMess("删除成功");
        return resultVo;
    }

    @RequestMapping("/workbench/activity/queryActivityDetailById")
    public String  queryActivityDetailById(String id,Model model) {
        Activity activity = activityService.queryActivityDetailById(id);
        model.addAttribute("activity",activity);
        return "forward:/toView/activity/detail";
    }


    @RequestMapping("/workbench/activity/updateActivityRemark")
    @ResponseBody
    public ResultVo updateActivityRemark(ActivityRemark activityRemark,HttpSession session){
        User user = (User) session.getAttribute(CrmConstants.LOGIN_USER);

        activityRemark.setEdit_by(user.getName());
        activityRemark.setEdit_time(DateTimeUtil.getSysTime());
        ResultVo resultVo = new ResultVo();
        try {
            activityService.updateActivityRemark(activityRemark);
        } catch (CrmException e) {
            resultVo.setOK(false);
            resultVo.setMess(e.getMessage());
            return resultVo;
        }
        resultVo.setOK(true);
        resultVo.setMess("更新成功");
        return resultVo;
    }


    @RequestMapping("/workbench/activity/deleteActivityRemark")
    @ResponseBody
    public ResultVo deleteActivityRemark(String  id){
        ResultVo resultVo = new ResultVo();
        try {
            activityService.deleteActivityRemark(id);
        } catch (CrmException e) {
            resultVo.setOK(false);
            resultVo.setMess(e.getMessage());
            return resultVo;
        }
        resultVo.setOK(true);
        resultVo.setMess("活动备注删除成功");
        return resultVo;
    }


    @RequestMapping("/workbench/activity/saveActivityRemark")
    @ResponseBody
    public ResultVo saveActivityRemark(ActivityRemark activityRemark,HttpSession httpSession){
        User user = (User) httpSession.getAttribute(CrmConstants.LOGIN_USER);
        activityRemark.setId(UUIDUtil.getUUID());
        activityRemark.setCreate_time(DateTimeUtil.getSysTime());
        activityRemark.setCreate_by(user.getName());
        activityRemark.setEdit_flag("1");
        activityRemark.setEdit_time(DateTimeUtil.getSysTime());
        activityRemark.setEdit_by(user.getName());
        ResultVo resultVo = new ResultVo();
        try {
            activityService.saveActivityRemark(activityRemark);
        } catch (CrmException e) {
            resultVo.setOK(false);
            resultVo.setMess(e.getMessage());
            return resultVo;
        }
        resultVo.setOK(true);
        resultVo.setMess("活动备注添加成功");
        return resultVo;
    }


    @RequestMapping("/workbench/activity/deleteActivityDetail")
    @ResponseBody
    public ResultVo deleteActivityDetail(String id) {
        ResultVo resultVo = new ResultVo();
        try {
            activityService.deleteActivityDetail(id);
        } catch (CrmException e) {
            resultVo.setOK(false);
            resultVo.setMess(e.getMessage());
            return resultVo;
        }
        resultVo.setOK(true);
        resultVo.setMess("活动删除成功");
        return resultVo;
    }
}
