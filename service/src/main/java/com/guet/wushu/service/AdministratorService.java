package com.guet.wushu.service;

import com.guet.wushu.entity.pojo.*;

import java.util.List;
import java.util.Map;

/**
 * @author asus
 * 管理员业务层
 */
public interface AdministratorService {

    /**
     * 查看用户信息
     * @return
     */
    List<User> viewUserInfo();

    String login(String name, String pwd);

    Administrator showPersonalInfo(int id);

    int completePersonalInfo(Map<String,String> administratorInfo);


}
