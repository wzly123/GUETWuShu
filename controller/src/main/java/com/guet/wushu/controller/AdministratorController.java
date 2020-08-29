package com.guet.wushu.controller;

import com.guet.wushu.entity.pojo.*;
import com.guet.wushu.entity.utils.JsonData;
import com.guet.wushu.service.*;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AdministratorController
 * @Author asus
 * @Version 1.0
 * 管理员的Controller层
 */
@RestController
@RequestMapping("api/v1/private/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private WuShuCultureService cultureService;

    @Autowired
    private WuShuEssenceService essenceService;

    @Autowired
    private WuShuIntroductionService introductionService;

    @Autowired
    private WuShuSpeciesService speciesService;

    @GetMapping("/login")
    public JsonData login(@RequestParam String name,@RequestParam String pwd){

        String token = administratorService.login(name, pwd);

        if(token != null){
            return JsonData.buildSuccess(token);
        }else {
            return JsonData.buildError("登录失败");
        }
    }

    /**
     * 查看个人信息
     * @param id
     * @return
     */
    @GetMapping("/userInfo")
    public JsonData checkUserInfo(@RequestParam int id) {

        Administrator administrator = administratorService.showPersonalInfo(id);

        if (administrator != null) {

            return JsonData.buildSuccess(administrator,"个人信息查看成功");

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

        int code = administratorService.completePersonalInfo(userInfo);

        if (code >= 0){
            return JsonData.buildError("用户信息更改成功");
        }
        return JsonData.buildError("用户信息更改失败");
    }

    @GetMapping
    public JsonData viewAllUsers(){

        List<User> users = administratorService.viewUserInfo();

        if (users != null) {

            return JsonData.buildSuccess(users);

        }else {

            return JsonData.buildError("查看失败");

        }
    }

    /**
     * 删除武术学习中的信息
     * @param delete
     * @param ids
     * @return
     */
    @RequestMapping(value = "/{delete}/{ids}", method = RequestMethod.DELETE)
    public JsonData delete(@PathVariable String delete,@PathVariable String ids){

        switch (delete){
            case "culture" : {
                Boolean result = cultureService.deleteInfo(ids);

                if (result){
                    return JsonData.buildSuccess("删除成功");
                }else {
                    return JsonData.buildError("删除失败");
                }
            }
            case "essence" : {
                Boolean result = essenceService.deleteInfo(ids);

                if (result){
                    return JsonData.buildSuccess("删除成功");
                }else {
                    return JsonData.buildError("删除失败");
                }
            }
            case "species" : {
                Boolean result = speciesService.deleteInfo(ids);

                if (result){
                    return JsonData.buildSuccess("删除成功");
                }else {
                    return JsonData.buildError("删除失败");
                }
            }
            case "introduction" : {
                Boolean result = introductionService.deleteInfo(ids);

                if (result){
                    return JsonData.buildSuccess("删除成功");
                }else {
                    return JsonData.buildError("删除失败");
                }
            }
        }

        return JsonData.buildError("URL出错，无法匹配");
    }

    /**
     * 更改武术学习中的信息
     * @param update
     * @param info
     * @return
     */
    @RequestMapping(value = "/{update}", method = RequestMethod.PUT)
    public JsonData update(@PathVariable String update,@RequestBody Map<String,String> info){

        int result;

        switch (update) {
            case "updateCulture" : {
                result = cultureService.updateInfo(info);

                if (result == 1){
                    return JsonData.buildSuccess("修改成功");
                }else {
                    return JsonData.buildError("修改失败");
                }
            }
            case "updateEssence" : {
                result = essenceService.updateInfo(info);

                if (result == 1){
                    return JsonData.buildSuccess("修改成功");
                }else {
                    return JsonData.buildError("修改失败");
                }
            }
            case "updateSpecies" : {
                result = speciesService.updateInfo(info);

                if (result == 1){
                    return JsonData.buildSuccess("修改成功");
                }else {
                    return JsonData.buildError("修改失败");
                }
            }
            case "updateIntroduction" : {
                result = introductionService.updateInfo(info);

                if (result == 1){
                    return JsonData.buildSuccess("修改成功");
                }else {
                    return JsonData.buildError("修改失败");
                }
            }
        }

        return JsonData.buildError("URL出错，无法匹配");
    }

    /**
     * 添加新的武术学习信息
     * @param insert
     * @param info
     * @return
     */
    @RequestMapping(value = "/{insert}", method = RequestMethod.POST)
    public JsonData insert(@PathVariable String insert, @RequestBody Map<String,String> info){

        int result;

        switch (insert) {
            case "insertCulture" : {
                result = cultureService.insertInfo(info);

                if (result == 1){
                    return JsonData.buildSuccess("添加成功");
                }else {
                    return JsonData.buildError("添加失败");
                }
            }
            case "insertEssence" : {
                result = essenceService.insertInfo(info);

                if (result == 1){
                    return JsonData.buildSuccess("添加成功");
                }else {
                    return JsonData.buildError("添加失败");
                }
            }
            case "insertSpecies" : {
                result = speciesService.insertInfo(info);

                if (result == 1){
                    return JsonData.buildSuccess("添加成功");
                }else {
                    return JsonData.buildError("添加失败");
                }
            }
            case "insertIntroduction" : {
                result = introductionService.insertInfo(info);

                if (result == 1){
                    return JsonData.buildSuccess("添加成功");
                }else {
                    return JsonData.buildError("添加失败");
                }
            }
        }

        return JsonData.buildError("URL出错，无法匹配");
    }


}
