package com.guet.wushu.service;

import com.guet.wushu.entity.pojo.Banner;

import java.util.List;
import java.util.Map;

/**
 * @author asus
 * 轮播图业务层
 */
public interface BannerService {

    /**
     * 添加新的轮播图
     * @param bannerInfo
     * @return
     */
    int insert(Map<String,String> bannerInfo);

    /**
     * 查找所有的轮播图
     * @return
     */
    List<Banner> selectAll();

    /**
     * 首页展示的轮播图
     * @return
     */
    List<Banner> homeDisplay();
}
