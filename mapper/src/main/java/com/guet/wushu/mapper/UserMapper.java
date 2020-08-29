package com.guet.wushu.mapper;

import com.guet.wushu.entity.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author asus
 * 用户mapper接口
 */
public interface UserMapper {

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 登录验证
     * @param name
     * @param pwd
     * @return
     */
    User login(String name,String pwd);

    /**
     * 完善用户信息
     * @param user
     * @return
     */
    int completeUserInfo(User user);

    /**
     * 根据Id查找相应的用户信息
     * @param id
     * @return
     */
    User selectById(int id);

    /**
     * 列出所有的用户
     * @return
     */
    List<User> selectAllUsers();
}
