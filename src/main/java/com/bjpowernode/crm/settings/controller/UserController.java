package com.bjpowernode.crm.settings.controller;

import com.bjpowernode.crm.base.constants.CrmConstants;
import com.bjpowernode.crm.base.exception.CrmException;
import com.bjpowernode.crm.settings.bean.User;
import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.settings.controller
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/16 20:05
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/queryUsers")
    @ResponseBody
    private List<User> queryUsers(){
        return userService.queryList();
    }

    @RequestMapping("/settings/user/login")
    private String login(User user, Model model, HttpSession session, HttpServletRequest request) throws CrmException {
        //获取用户登录的ip
        String ip = request.getRemoteAddr();
        user.setAllowIps(ip);
        try {
            user = userService.login(user);
            session.setAttribute(CrmConstants.LOGIN_USER,user);
        }catch (CrmException e){
            //登录失败，各种异常
            String mess = e.getMessage();
            model.addAttribute("mess",mess);
            //转发到登录页面，显示错误信息
            return "../../login";
        }

        return "index";
    }

    @RequestMapping("/settings/user/loginOut")
    private String loginOut(HttpSession httpSession){
        httpSession.removeAttribute(CrmConstants.LOGIN_USER);
        return "../../login";
    }
}
