import com.bjpowernode.crm.base.util.UUIDUtil;
import com.bjpowernode.crm.workbench.bean.Activity;
import com.bjpowernode.crm.workbench.mapper.ActivityMapper;
import com.bjpowernode.crm.base.constants.CrmExceptionEnum;
import com.bjpowernode.crm.base.exception.CrmException;
import com.bjpowernode.crm.base.util.MD5Util;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ProjectName: crm
 * @Package: PACKAGE_NAME
 * @Description: java类作用描述
 * @Author: 毛宇豪
 * @CreateDate: 2020/11/16 19:28
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2020
 */

public class Testtt {
    @Test
    public void test01(){
        try {
            System.out.println(CrmExceptionEnum.LOGIN_ACCOUNT_EXPIRE.getMess());
            throw new CrmException(CrmExceptionEnum.LOGIN_ACCOUNT_EXPIRE);
        } catch (CrmException e) {
            System.out.println(e.getMessage());
        }

    }


    @Test
    public void test02(){
        String admin = MD5Util.getMD5("zhangsan");
        System.out.println(admin);
    }


    @Test
    public void test03(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActivityMapper mapper = sqlSession.getMapper(ActivityMapper.class);
        List<Activity> activities = mapper.selectAll();
        System.out.println(activities);
    }

    @Test
    public void UUIDtest04(){

        System.out.println(UUIDUtil.getUUID());
    }


    @Test
    public void test05(){
        System.out.println("  ".trim().equals("      ".trim()));
    }
}
