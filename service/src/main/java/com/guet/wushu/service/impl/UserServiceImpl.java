package com.guet.wushu.service.impl;

import com.guet.wushu.entity.pojo.User;
import com.guet.wushu.entity.utils.JWTUtils;
import com.guet.wushu.entity.utils.MD5Utils;
import com.guet.wushu.mapper.UserMapper;
import com.guet.wushu.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Author asus
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(Map<String, String> UserInfo) {
        User user = loginParseToUser(UserInfo);

        if (user != null) {
            return userMapper.save(user);
        }
        return -1;
    }

    @Override
    public String login(String name,String pwd) {
        User user = userMapper.login(name, MD5Utils.MD5(pwd));

        if (user == null) {
            return null;
        } else {
            String token = JWTUtils.geneJsonWebUserToken(user);
            return token;
        }

    }

    @Override
    public User checkUserInfo(int id) {

        User user = userMapper.selectById(id);

        if (user != null) {
            return user;
        }

        return null;
    }

    @Override
    public int completeUserInfo(Map<String,String> userInfo) {

        User user = updateParseToUser(userInfo);

        if (user != null) {
            userMapper.completeUserInfo(user);
            return 0;
        }

        return -1;
    }


    /**
     * 将传入的JSON数据转换成JAVA类的形式
     * @param userInfo
     * @return
     */
    private User updateParseToUser(Map<String,String> userInfo){

        User user = new User();

        if (userInfo.containsKey("name") && userInfo.containsKey("phoneNumber") && userInfo.containsKey("pwd")){
            user.setId(Integer.valueOf(userInfo.get("id")));
            user.setName(userInfo.get("name"));
            user.setPhoneNumber(userInfo.get("phoneNumber"));
            String pwd = MD5Utils.MD5(userInfo.get("pwd"));
            user.setPwd(pwd);
            user.setRealName(userInfo.get("realName"));
            user.setIntroduction("introduction");
            user.setSex(userInfo.get("sex"));
            user.setMajor(userInfo.get("major"));
            user.setAcademy(userInfo.get("academy"));

            return user;
        }
        return null;
    }

    private User loginParseToUser(Map<String,String> userInfo){
        User user = new User();


        if (userInfo.containsKey("name") && userInfo.containsKey("studentId")
                && userInfo.containsKey("phoneNumber") && userInfo.containsKey("pwd")){
            user.setName(userInfo.get("name"));
            user.setStudentId(userInfo.get("studentId"));
            user.setPhoneNumber(userInfo.get("phoneNumber"));
            String pwd = MD5Utils.MD5(userInfo.get("pwd"));
            user.setPwd(pwd);
            user.setCreateTime(new Timestamp(System.currentTimeMillis()));

            return user;
        }
        return null;
    }
}
