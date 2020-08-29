package com.guet.wushu.service.impl;

import com.guet.wushu.entity.pojo.WuShuIntroduction;
import com.guet.wushu.entity.pojo.WuShuSpecies;
import com.guet.wushu.mapper.WuShuSpeciesMapper;
import com.guet.wushu.service.WuShuSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.SliderUI;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WuShuSpeciesServiceImpl
 * @Author asus
 * @Version 1.0
 */
@Service
public class WuShuSpeciesServiceImpl implements WuShuSpeciesService {

    @Autowired
    private WuShuSpeciesMapper speciesMapper;


    @Override
    public WuShuSpecies selectByTd(int id) {
        return speciesMapper.selectInfoById(id);
    }

    @Override
    public List<WuShuSpecies> displayInfo() {
        return speciesMapper.selectAll();
    }

    @Override
    public int updateNewClickRecord(WuShuSpecies species) {
        return speciesMapper.updateNewClickRecord(species);
    }

    @Override
    public int insertInfo(Map<String,String> info) {

        WuShuSpecies species = insertParse(info);

        return speciesMapper.insertNewContent(species);
    }

    @Override
    public Boolean deleteInfo(String ids) {

        String[] split = ids.split(",");

        int result = speciesMapper.deleteByIds(split);

        return result == split.length;
    }

    @Override
    public int updateInfo(Map<String, String> info) {

        WuShuSpecies species = updateParse(info);

        return speciesMapper.updateInfo(species);
    }

    /**
     * 将传入的JSON数据转换成JAVA类的形式
     * @param info
     * @return
     */
    private WuShuSpecies updateParse(Map<String, String> info) {

        WuShuSpecies species = new WuShuSpecies();

        if (info.containsValue("title") || info.containsValue("content") && info.containsValue("id")) {

            species.setTitle(info.get("title"));
            species.setContent(info.get("content"));
            species.setsId(Integer.valueOf(info.get("id")));

            return species;
        }else {

            return null;
        }
    }

    private WuShuSpecies insertParse(Map<String,String> info){

        WuShuSpecies species = new WuShuSpecies();

        if (info.containsKey("title") && info.containsKey("content")){

            species.setTitle(info.get("title"));
            species.setContent(info.get("content"));
            species.setStudyId(1);
            species.setCreateTime(new Timestamp(System.currentTimeMillis()));

            return species;
        }

        return null;
    }
}
