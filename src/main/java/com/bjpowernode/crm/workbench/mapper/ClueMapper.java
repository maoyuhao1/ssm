package com.bjpowernode.crm.workbench.mapper;

import com.bjpowernode.crm.workbench.bean.Clue;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.mapper
 * @Description: java接口作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/21 20:27
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */
public interface ClueMapper extends Mapper<Clue> {
    List<Clue> queryList();
}
