package com.bjpowernode.crm.workbench.controller;

import com.bjpowernode.crm.base.bean.PaginationVo;
import com.bjpowernode.crm.settings.bean.User;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.workbench.bean.Activity;
import com.bjpowernode.crm.workbench.bean.Clue;
import com.bjpowernode.crm.workbench.bean.ClueQueryVo;
import com.bjpowernode.crm.workbench.service.ClueService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.controller
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/21 20:01
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class ClueController {
    @Autowired
    private ClueService clueService;

    @Autowired
    private UserService userService;

    @RequestMapping("/workbench/clue/queryList")
    @ResponseBody
    public PaginationVo queryList(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "2") int  pageSize,
                                  ClueQueryVo clueQueryVo){
        PageHelper.startPage(page,pageSize);
        List<Clue> clueList = clueService.queryList();
        PageInfo<Clue> pageInfo = new PageInfo<>(clueList);
        PaginationVo paginationVo = new PaginationVo(pageInfo);
        return paginationVo;
    }

    @RequestMapping("/workbench/activity/queryAllUsers")
    @ResponseBody
    public List<User> queryAllUsers(){
        return userService.queryList();
    }

    @RequestMapping("/workbench/clue/queryClueDetailById")
    public String queryClueDetailById(String id, Model model){
        Clue clue = clueService.queryClueDetailById(id);
        model.addAttribute("clue",clue);
        return "/clue/detail";
    }

    @RequestMapping("/workbench/clue/queryClueActivity")
    @ResponseBody
    public List<Activity> queryClueActivity(String clueId){
        return clueService.queryClueActivity(clueId);
    }


    @RequestMapping("/workbench/clue/queryActivityExculdeNow")
    @ResponseBody
    public List<Activity> queryActivityExculdeNow(String clueId,String activityName){
        return clueService.queryActivityExculdeNow(clueId,activityName);
    }
}
