package com.guet.wushu.controller;

import com.guet.wushu.entity.pojo.Banner;
import com.guet.wushu.entity.utils.JsonData;
import com.guet.wushu.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BannerController
 * @Author asus
 * @Version 1.0
 * 轮播图的Controller层
 */
@RestController
@RequestMapping("/api/v1/pub")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * 添加新的轮播图
     * @param bannerInfo
     * @return
     */
    @PostMapping("/addNewBanner")
    public JsonData addNewBanner(@RequestBody Map<String,String> bannerInfo){

        if (bannerService.insert(bannerInfo) != -1) {

            return JsonData.buildSuccess(0, null, "新增轮播图成功");

        }else {

            return JsonData.buildError("轮播图添加失败");

        }
    }

    /**
     * 轮播图首页展示
     * @return
     */
    @GetMapping("/homePage")
    public JsonData homePage(){

        List<Banner> banners = bannerService.homeDisplay();

        return JsonData.buildSuccess(banners);
    }
}
