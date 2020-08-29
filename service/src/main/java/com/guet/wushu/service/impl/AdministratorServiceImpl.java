package com.guet.wushu.service.impl;

import com.guet.wushu.entity.pojo.*;
import com.guet.wushu.entity.utils.JWTUtils;
import com.guet.wushu.entity.utils.MD5Utils;
import com.guet.wushu.mapper.*;
import com.guet.wushu.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AdministratorServiceImpl
 * @Author asus
 * @Version 1.0
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> viewUserInfo() {
        return userMapper.selectAllUsers();
    }

    @Override
    public String login(String name, String pwd) {

        Administrator administrator = administratorMapper.login(name, MD5Utils.MD5(pwd));

        if (administrator == null) {
            return null;
        } else {
            String token = JWTUtils.geneJsonWebAdministratorToken(administrator);

            return token;
        }

    }

    @Override
    public Administrator showPersonalInfo(int id) {
        return administratorMapper.selectInfoById(id);
    }

    @Override
    public int completePersonalInfo(Map<String,String> administratorInfo) {

        Administrator administrator = updateParseToAdministrator(administratorInfo);

        if (administrator != null){
            return administratorMapper.completeInfo(administrator);
        }

        return -1;
    }


    /**
     * 将传入的JSON数据转换成JAVA类的形式
     * @param userInfo
     * @return
     */
    private Administrator updateParseToAdministrator(Map<String,String> userInfo){

        Administrator administrator = new Administrator();

        if (userInfo.containsKey("name") && userInfo.containsKey("phoneNumber") && userInfo.containsKey("pwd")){
            administrator.setId(Integer.valueOf(userInfo.get("id")));
            administrator.setName(userInfo.get("name"));
            administrator.setPhoneNumber(userInfo.get("phoneNumber"));
            String pwd = MD5Utils.MD5(userInfo.get("pwd"));
            administrator.setPwd(pwd);
            administrator.setRealName(userInfo.get("realName"));
            administrator.setIntroduction("introduction");
            administrator.setSex(userInfo.get("sex"));
            administrator.setMajor(userInfo.get("major"));
            administrator.setAcademy(userInfo.get("academy"));

            return administrator;
        }
        return null;
    }

}
