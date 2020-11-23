package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.base.bean.DictionaryType;

import java.util.List;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.settings.service
 * @Description: java接口作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/23 9:24
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface DictionaryService  {
    List<DictionaryType> queryDictionary();
}
