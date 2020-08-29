package com.guet.wushu.service;

import com.guet.wushu.entity.pojo.User;

import java.util.Map;

/**
 * @author asus
 * 用户的业务层
 */
public interface UserService {
    /**
     * 保存用户信息
     * @param UserInfo
     * @return
     */
    int save(Map<String,String> UserInfo);

    /**
     * 登录
     * @param name
     * @param pwd
     * @return
     */
    String login(String name,String pwd);

    /**
     * 检查用户信息
     * @param id
     * @return
     */
    User checkUserInfo(int id);

    /**
     * 完善用户信息
     * @param userInfo
     * @return
     */
    int completeUserInfo(Map<String,String> userInfo);
}
