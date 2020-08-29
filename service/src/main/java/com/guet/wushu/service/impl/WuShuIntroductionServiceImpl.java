package com.guet.wushu.service.impl;

import com.guet.wushu.entity.pojo.WuShuCulture;
import com.guet.wushu.entity.pojo.WuShuEssence;
import com.guet.wushu.entity.pojo.WuShuIntroduction;
import com.guet.wushu.mapper.WuShuIntroductionMapper;
import com.guet.wushu.service.WuShuIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WuShuIntroductionServiceImpl
 * @Author asus
 * @Version 1.0
 */
@Service
public class WuShuIntroductionServiceImpl implements WuShuIntroductionService {

    @Autowired
    private WuShuIntroductionMapper introductionMapper;


    @Override
    public WuShuIntroduction selectByTd(int id) {
        return introductionMapper.selectInfoById(id);
    }

    @Override
    public List<WuShuIntroduction> displayInfo() {
        return introductionMapper.selectAll();
    }

    @Override
    public int updateNewClickRecord(WuShuIntroduction introduction) {
        return introductionMapper.updateNewClickRecord(introduction);
    }

    @Override
    public int insertInfo(Map<String,String> info) {

        WuShuIntroduction introduction = insertParse(info);

        return introductionMapper.insertNewContent(introduction);
    }

    @Override
    public Boolean deleteInfo(String ids) {

        String[] split = ids.split(",");

        int result = introductionMapper.deleteByIds(split);

        return result == split.length;
    }

    @Override
    public int updateInfo(Map<String, String> info) {

        WuShuIntroduction introduction = updateParse(info);

        return introductionMapper.updateInfo(introduction);
    }

    /**
     * 将传入的JSON数据转换成JAVA类的形式
     * @param info
     * @return
     */
    private WuShuIntroduction updateParse(Map<String, String> info) {

        WuShuIntroduction introduction = new WuShuIntroduction();

        if (info.containsValue("title") || info.containsValue("content") && info.containsValue("id")) {

            introduction.setTitle(info.get("title"));
            introduction.setContent(info.get("content"));
            introduction.setiId(Integer.valueOf(info.get("id")));

            return introduction;
        }else {

            return null;
        }
    }

    private WuShuIntroduction insertParse(Map<String,String> info){

        WuShuIntroduction introduction = new WuShuIntroduction();

        if (info.containsKey("title") && info.containsKey("content")){

            introduction.setTitle(info.get("title"));
            introduction.setContent(info.get("content"));
            introduction.setStudyId(1);
            introduction.setCreateTime(new Timestamp(System.currentTimeMillis()));

            return introduction;
        }

        return null;
    }
}
