package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.base.exception.CrmException;
import com.bjpowernode.crm.settings.bean.User;

import java.util.List;

public interface UserService {

    List<User> queryList();

    User login(User user) throws CrmException;
}
