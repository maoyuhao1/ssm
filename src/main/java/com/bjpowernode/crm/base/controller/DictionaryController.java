package com.bjpowernode.crm.base.controller;

import com.bjpowernode.crm.base.bean.DictionaryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.base.controller
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/23 10:57
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Controller
public class DictionaryController {

    @RequestMapping("/dictionaryCache")
    @ResponseBody
    public List<DictionaryType> dictionaryCache(HttpSession session){
        ServletContext servletContext = session.getServletContext();


        List<DictionaryType> dictionaryTypes = (List<DictionaryType>) servletContext.getAttribute("dictionaryTypes");
        return dictionaryTypes;
    }
}
