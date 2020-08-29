package com.guet.wushu.controller;

import com.guet.wushu.entity.pojo.*;
import com.guet.wushu.entity.utils.JsonData;
import com.guet.wushu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName StudyController
 * @Author asus
 * @Version 1.0
 * 武术学习的Controller层
 */
@RestController
@RequestMapping("/api/v1/pub/study")
public class StudyController {

    @Autowired
    private WuShuSpeciesService speciesService;

    @Autowired
    private WuShuCultureService cultureService;

    @Autowired
    private WuShuEssenceService essenceService;

    @Autowired
    private WuShuIntroductionService introductionService;

    @Autowired
    private StudyService studyService;

    @Autowired
    private StudyTimingService studyTimingService;

    /**
     * 武术学习页面的展示
     * @return
     */
    @GetMapping
    public JsonData studyDisplay(){

        Study study = studyService.studyDisplay(1);

        return JsonData.buildSuccess(study);
    }

    /**
     * 武术学习中的热搜展示
     * @return
     */
    @GetMapping("/hotSearch")
    public JsonData hotSearch(){

        List<Map.Entry<String, Integer>> resultList = studyTimingService.getAllTimingInfo();

        return JsonData.buildSuccess(resultList);
    }

    /**
     * 武术学习中的武术种类展示
     * @param speciesId
     * @return
     */
    @GetMapping("/species/{speciesId}")
    public JsonData wuShuSpecies(@PathVariable String speciesId){

        //从规定的URL:/xxxx/xxxx/species_id中,得到要查询的id
        int id = Integer.valueOf((speciesId).substring(8));

        WuShuSpecies species = speciesService.selectByTd(id);

        if (species.getClickTimes() == null) {
            species.setClickTimes(0);
        }


        //表明当前的武术种类点击数加一
        int clickTimes = species.getClickTimes() + 1;

        species.setClickTimes(clickTimes);

        int row = speciesService.updateNewClickRecord(species);

        if (row < 0){
            JsonData.buildError("点击失败");
        }

        return JsonData.buildSuccess(species);
    }

    /**
     * 武术学习中的武术精髓展示
     * @param essenceId
     * @return
     */
    @GetMapping("/essence/{essenceId}")
    public JsonData wuShuEssence(@PathVariable String essenceId){

        //从规定的URL:/xxxx/xxxx/essence_id中,得到要查询的id
        int id = Integer.valueOf((essenceId).substring(8));

        WuShuEssence essence = essenceService.selectByTd(id);


        if (essence.getClickTimes() == null) {
            essence.setClickTimes(0);
        }

        int clickTimes = essence.getClickTimes() + 1;

        essence.setClickTimes(clickTimes);

        int row = essenceService.updateNewClickRecord(essence);

        if (row < 0){
            return JsonData.buildError("点击失败");
        }

        return JsonData.buildSuccess(essence);
    }

    /**
     * 武术学习中的武术文化展示
     * @param cultureId
     * @return
     */
    @GetMapping("/culture/{cultureId}")
    public JsonData wuShuCulture(@PathVariable String cultureId) {

        //从规定的URL:/xxxx/xxxx/culture_id中,得到要查询的id
        int id = Integer.valueOf((cultureId).substring(8));

        WuShuCulture culture = cultureService.selectByTd(id);

        if (culture.getClickTimes() == null){
            culture.setClickTimes(0);
        }

        int clickTimes = culture.getClickTimes() + 1;

        culture.setClickTimes(clickTimes);

        int row = cultureService.updateNewClickRecord(culture);

        if (row < 0){
            return JsonData.buildError("点击失败");
        }

        return JsonData.buildSuccess(culture);
    }

    /**
     * 武术学习中的武术介绍展示
     * @param introductionId
     * @return
     */
    @GetMapping("/introduction/{introductionId}")
    public JsonData WuShuIntroduction(@PathVariable String introductionId) {

        //从规定的URL:/xxxx/xxxx/introduction_id中,得到要查询的id
        int id = Integer.valueOf((introductionId).substring(13));

        WuShuIntroduction introduction = introductionService.selectByTd(id);

        if (introduction.getClickTimes() == null) {
            introduction.setClickTimes(0);
        }

        int clickTimes = introduction.getClickTimes() + 1;

        introduction.setClickTimes(clickTimes);

        int row = introductionService.updateNewClickRecord(introduction);

        if (row < 0){
            return JsonData.buildError("点击失败");
        }

        return JsonData.buildSuccess(introduction);
    }

}
