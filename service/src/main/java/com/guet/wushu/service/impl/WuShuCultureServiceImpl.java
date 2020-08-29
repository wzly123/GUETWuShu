package com.guet.wushu.service.impl;

import com.guet.wushu.entity.pojo.WuShuCulture;
import com.guet.wushu.mapper.WuShuCultureMapper;
import com.guet.wushu.service.WuShuCultureService;
import jdk.nashorn.internal.objects.NativeUint8Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WuShuCultureServiceImpl
 * @Author asus
 * @Version 1.0
 */
@Service
public class WuShuCultureServiceImpl implements WuShuCultureService {

    @Autowired
    private WuShuCultureMapper cultureMapper;


    @Override
    public WuShuCulture selectByTd(int id) {
        return cultureMapper.selectInfoById(id);
    }

    @Override
    public List<WuShuCulture> displayInfo() {
        return cultureMapper.selectAll();
    }

    @Override
    public int updateNewClickRecord(WuShuCulture culture) {


        return cultureMapper.updateNewClickRecord(culture);
    }

    @Override
    public int insertInfo(Map<String,String> info) {

        WuShuCulture culture = insertParse(info);

        return cultureMapper.insertNewContent(culture);

    }

    @Override
    public Boolean deleteInfo(String ids) {

        String[] split = ids.split(",");

        int result = cultureMapper.deleteByIds(split);

        return result == split.length;
    }

    @Override
    public int updateInfo(Map<String,String> info) {

        WuShuCulture culture = updateParse(info);

        return cultureMapper.updateInfo(culture);
    }

    /**
     * 将传入的JSON数据转换成JAVA类的形式
     * @param info
     * @return
     */
    private WuShuCulture updateParse(Map<String, String> info) {

        WuShuCulture culture = new WuShuCulture();

        if (info.containsValue("title") || info.containsValue("content") && info.containsValue("id")) {

            culture.setTitle(info.get("title"));
            culture.setContent(info.get("content"));
            culture.setcId(Integer.valueOf(info.get("id")));

            return culture;
        }else {

            return null;
        }
    }

    private WuShuCulture insertParse(Map<String,String> info){

        WuShuCulture culture = new WuShuCulture();

        if (info.containsKey("title") && info.containsKey("content")){

            culture.setTitle(info.get("title"));
            culture.setContent(info.get("content"));
            culture.setStudyId(1);
            culture.setCreateTime(new Timestamp(System.currentTimeMillis()));

            return culture;
        }

        return null;
    }
}
