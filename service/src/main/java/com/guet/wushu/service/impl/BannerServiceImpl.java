package com.guet.wushu.service.impl;

import com.guet.wushu.entity.pojo.Banner;
import com.guet.wushu.mapper.BannerMapper;
import com.guet.wushu.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @ClassName NewBannerServiceImpl
 * @Author asus
 * @Version 1.0
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;


    @Override
    public int insert(Map<String,String> bannerInfo) {

        Banner banner = null;
        try {
            banner = parseToBanner(bannerInfo);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (banner != null) {
            return bannerMapper.insert(banner);
        }else {
            return -1;
        }

    }

    @Override
    public List<Banner> selectAll() {
        return bannerMapper.selectAll();
    }


    @Override
    public List<Banner> homeDisplay() {

        List<Banner> list = selectAll();

        int[] ids = new int[list.size()];
        int[] param = new int[list.size()];
        int x = 0;
        int j = 0;

        for (Banner item:list
             ) {
            if (item.getId() > list.size() - 4) {
                param[x] = item.getId();
                x++;
            }
        }

        for (int i = x - 1; i >= 0; i--) {
            ids[j] = param[i];
            j++;
        }

        return bannerMapper.homeDisplay(ids);
    }

    /**
     * 将传入的JSON数据转换成JAVA类的形式
     * @param bannerInfo
     * @return
     */
    private Banner parseToBanner(Map<String,String> bannerInfo) throws ParseException {
        Banner banner = new Banner();
        if (bannerInfo.containsKey("name")&&bannerInfo.containsKey("imag")&&bannerInfo.containsKey("weight")
        &&bannerInfo.containsKey("create_time")&&bannerInfo.containsKey("url")){
            banner.setName((String) bannerInfo.get("name"));
            banner.setUrl((String)bannerInfo.get("url"));
            banner.setWeight(Integer.valueOf(bannerInfo.get("weight")));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            banner.setCreateTime(format.parse(bannerInfo.get("create_time")));
            return banner;
        }else {
            return null;
        }

    }
}
