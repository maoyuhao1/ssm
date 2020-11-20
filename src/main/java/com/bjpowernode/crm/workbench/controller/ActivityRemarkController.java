package com.bjpowernode.crm.workbench.controller;

import com.bjpowernode.crm.workbench.service.ActivityRemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.controller
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/18 17:04
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class ActivityRemarkController {
    @Autowired
    private ActivityRemarkService activityRemarkService;

    @RequestMapping("/workbench/activity/toDetailView")
    private ModelAndView toDetailView(){
        return null;
    }
}
