package com.guet.wushu.service.impl;

import com.guet.wushu.entity.pojo.*;
import com.guet.wushu.mapper.WuShuCultureMapper;
import com.guet.wushu.mapper.WuShuEssenceMapper;
import com.guet.wushu.mapper.WuShuIntroductionMapper;
import com.guet.wushu.mapper.WuShuSpeciesMapper;
import com.guet.wushu.service.StudyTimingService;
import org.apache.logging.log4j.util.PropertySource;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import javax.management.monitor.StringMonitor;
import javax.servlet.http.HttpSessionActivationListener;
import java.util.*;

/**
 * @ClassName StudyTimingServiceImpl
 * @Author asus
 * @Version 1.0
 */
@Service
public class StudyTimingServiceImpl implements StudyTimingService {

    @Autowired
    private WuShuSpeciesMapper speciesMapper;

    @Autowired
    private WuShuIntroductionMapper introductionMapper;

    @Autowired
    private WuShuEssenceMapper essenceMapper;

    @Autowired
    private WuShuCultureMapper cultureMapper;

    /**
     * 统计所有的点击数，选出前十作为热搜
     * @return
     */
    @Override
    public List<Map.Entry<String, Integer>> getAllTimingInfo() {

        StudyTimingEntity entity = new StudyTimingEntity();

        entity.setCultureList(cultureMapper.selectAll());
        entity.setEssenceList(essenceMapper.selectAll());
        entity.setIntroductionsList(introductionMapper.selectAll());
        entity.setSpeciesList(speciesMapper.selectAll());

        Map<String, Integer> resultMap = new HashMap<>(40);

        Map<String, Integer> cultureMap = new HashMap<>(10);
        Map<String, Integer> essenceMap = new HashMap<>(10);
        Map<String, Integer> introductionMap = new HashMap<>(10);
        Map<String, Integer> speciesMap = new HashMap<>(10);

        for (WuShuCulture culture:entity.getCultureList()
        ){
            cultureMap.put(culture.getTitle(), culture.getClickTimes());
        }

        for (WuShuEssence essence : entity.getEssenceList()
        ) {
            essenceMap.put(essence.getTitle(), essence.getClickTimes());
        }

        for (WuShuIntroduction introduction : entity.getIntroductionsList()
        ) {
            introductionMap.put(introduction.getTitle(), introduction.getClickTimes());
        }

        for (WuShuSpecies species : entity.getSpeciesList()
        ) {
            speciesMap.put(species.getTitle(), species.getClickTimes());
        }

        resultMap.putAll(cultureMap);
        resultMap.putAll(essenceMap);
        resultMap.putAll(introductionMap);
        resultMap.putAll(speciesMap);

        List<Map.Entry<String, Integer>> resultList = new ArrayList<Map.Entry<String, Integer>>(resultMap.entrySet());

        Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        if (resultList.size() > 10) {
            resultList = resultList.subList(0, 10);
        }

        return resultList;
    }

}
