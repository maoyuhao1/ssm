package com.bjpowernode.crm.workbench.mapper;

import com.bjpowernode.crm.workbench.bean.Activity;
import com.bjpowernode.crm.workbench.bean.ActivityQureyVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: crm
 * @Package: com.bjpowernode.crm.workbench.mapper
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/17 16:11
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */

public interface ActivityMapper extends Mapper<Activity> {
    List<Map<String,String>> queryList(ActivityQureyVo activityQureyVo);

    List<Map<String, String>> queryActivityById(@Param("activityId") String activityId);
}
