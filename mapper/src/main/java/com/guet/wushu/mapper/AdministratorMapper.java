package com.guet.wushu.mapper;

import com.guet.wushu.entity.pojo.*;

import java.util.List;

/**
 * @author asus
 * 管理员mapper接口
 */
public interface AdministratorMapper {

    /**
     * 管理员登录
     * @param name
     * @param pwd
     * @return
     */
    Administrator login(String name, String pwd);

    /**
     * 管理员个人信息完善
     * @param administrator
     * @return
     */
    int completeInfo(Administrator administrator);


    /**
     * 根据id查找管理员信息
     * @param id
     * @return
     */
    Administrator selectInfoById(int id);
}
