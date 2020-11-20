package com.bjpowernode.crm.base.controller;

import com.bjpowernode.crm.base.exception.CrmException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.base.controller
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/18 8:43
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o,
                                         Exception e) {

        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof CrmException){
            modelAndView.addObject("mess",e.getMessage());
            modelAndView.setViewName("../../login");
        }else {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
