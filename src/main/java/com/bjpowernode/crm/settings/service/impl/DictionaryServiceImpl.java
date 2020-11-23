package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.base.bean.DictionaryType;
import com.bjpowernode.crm.base.bean.DictionaryValue;
import com.bjpowernode.crm.settings.mapper.DictionaryTypeMapper;
import com.bjpowernode.crm.settings.mapper.DictionaryValueMapper;
import com.bjpowernode.crm.settings.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.settings.service.impl
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/23 9:24
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryTypeMapper dictionaryTypeMapper;

    @Autowired
    private DictionaryValueMapper dictionaryValueMapper;
    @Override
    public List<DictionaryType> queryDictionary() {
        List<DictionaryType> dictionaryTypes = dictionaryTypeMapper.selectAll();

        for (DictionaryType dictionaryType : dictionaryTypes) {
            Example example = new Example(DictionaryValue.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("typeCode",dictionaryType.getCode());
            example.orderBy("orderNo");
            List<DictionaryValue> dictionaryValues = dictionaryValueMapper.selectByExample(example);
            dictionaryType.setDictionaryValues(dictionaryValues);
        }
        return dictionaryTypes;
    }
}
