package com.guet.wushu.controller;

import com.guet.wushu.entity.pojo.User;
import com.guet.wushu.entity.utils.JsonData;
import com.guet.wushu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName UserController
 * @Author asus
 * @Version 1.0
 * 用户的Controller层
 */
@RestController
@RequestMapping("/api/v1/pri")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    @PostMapping("/register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {

        if (userService.save(userInfo) != -1) {

            return JsonData.buildSuccess(0, null, "注册成功");

        }

        return JsonData.buildError("注册失败");
    }

    /**
     * 用户登录
     * @param name
     * @param pwd
     * @return
     */
    @GetMapping("/login")
    public JsonData login(@RequestParam String name, @RequestParam String pwd) {

        //检验输入的昵称和密码，并返回token信息
        String token = userService.login(name, pwd);

        if (token != null) {

            return JsonData.buildSuccess(token);

        } else {
            return JsonData.buildError("用户名或者密码错误");
        }

    }

    /**
     * 查看个人信息
     * @param id
     * @return
     */
    @GetMapping("/userInfo")
    public JsonData checkUserInfo(@RequestParam int id) {

        User user = userService.checkUserInfo(id);

        if (user != null) {

            return JsonData.buildSuccess(user,"个人信息查看成功");

        }else {

            return JsonData.buildError("个人信息查看失败");

        }

    }

    /**
     * 完善个人信息
     * @param userInfo
     * @return
     */
    @PostMapping("/completeUserInfo")
    public JsonData completeUserInfo(@RequestBody Map<String,String> userInfo){

        int code = userService.completeUserInfo(userInfo);

        if (code == 0){
            return JsonData.buildError("用户信息更改成功");
        }
        return JsonData.buildError("用户信息更改失败");
    }

}
