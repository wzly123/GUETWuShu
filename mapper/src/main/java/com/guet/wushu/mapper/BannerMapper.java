package com.guet.wushu.mapper;

import com.guet.wushu.entity.pojo.Banner;

import java.util.List;

/**
 * @author asus
 * 轮播图mapper接口
 */
public interface BannerMapper {

    /**
     * 插入新的轮播图
     * @param banner
     * @return
     */
    int insert(Banner banner);

    /**
     * 查看所有的轮播图
     * @return
     */
    List<Banner> selectAll();

    /**
     * 首页展示的轮播图
     * @param ids
     * @return
     */
    List<Banner> homeDisplay(int[] ids);

    /**
     * 修改轮播图信息
     * @param banner
     * @return
     */
    int updateBanner(Banner banner);
}
