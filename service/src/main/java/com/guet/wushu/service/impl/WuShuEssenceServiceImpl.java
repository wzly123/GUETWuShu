package com.guet.wushu.service.impl;

import com.guet.wushu.entity.pojo.WuShuCulture;
import com.guet.wushu.entity.pojo.WuShuEssence;
import com.guet.wushu.mapper.WuShuEssenceMapper;
import com.guet.wushu.service.WuShuEssenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @ClassName WuShuEssenceServiceImpl
 * @Author asus
 * @Version 1.0
 */
@Service
public class WuShuEssenceServiceImpl implements WuShuEssenceService {

    @Autowired
    private WuShuEssenceMapper essenceMapper;


    @Override
    public WuShuEssence selectByTd(int id) {
        return essenceMapper.selectInfoById(id);
    }

    @Override
    public List<WuShuEssence> displayInfo() {
        return essenceMapper.selectAll();
    }

    @Override
    public int updateNewClickRecord(WuShuEssence essence) {
        return essenceMapper.updateNewClickRecord(essence);
    }

    @Override
    public int insertInfo(Map<String,String> info) {

        WuShuEssence essence = insertParse(info);

        return essenceMapper.insertNewContent(essence);

    }

    @Override
    public Boolean deleteInfo(String ids) {

        String[] split = ids.split(",");

        int result = essenceMapper.deleteByIds(split);

        return result == split.length;
    }

    @Override
    public int updateInfo(Map<String, String> info) {

        WuShuEssence essence = updateParse(info);

        return essenceMapper.updateInfo(essence);
    }

    private WuShuEssence updateParse(Map<String, String> info) {

        WuShuEssence essence = new WuShuEssence();

        if (info.containsKey("title") || info.containsKey("content") && info.containsKey("id")) {

            essence.setTitle(info.get("title"));
            essence.setContent(info.get("content"));
            essence.seteId(Integer.valueOf(info.get("id")));

            return essence;
        }else {

            return null;
        }
    }

    /**
     * 将传入的JSON数据转换成JAVA类的形式
     * @param info
     * @return
     */
    private WuShuEssence insertParse(Map<String,String> info){

        WuShuEssence essence = new WuShuEssence();

        if (info.containsKey("title") && info.containsKey("content")){

            essence.setTitle(info.get("title"));
            essence.setContent(info.get("content"));
            essence.setStudyId(1);
            essence.setCreateTime(new Timestamp(System.currentTimeMillis()));

            return essence;
        }

        return null;
    }
}
