package com.guet.wushu.entity.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StudyTimingEntity
 * @Author asus
 * @Version 1.0
 * @Description 热搜榜单
 */
public class StudyTimingEntity implements Serializable {

    /**
     * 武术种类
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("species_list")
    private List<WuShuSpecies> speciesList;

    /**
     * 武术介绍
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("introductions_list")
    private List<WuShuIntroduction> introductionsList;

    /**
     * 武术文化
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("culture_list")
    private List<WuShuCulture> cultureList;

    /**
     * 武术精髓
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("essence_list")
    private List<WuShuEssence> essenceList;

    public StudyTimingEntity() {
    }

    public List<WuShuSpecies> getSpeciesList() {
        return speciesList;
    }

    public void setSpeciesList(List<WuShuSpecies> speciesList) {
        this.speciesList = speciesList;
    }

    public List<WuShuIntroduction> getIntroductionsList() {
        return introductionsList;
    }

    public void setIntroductionsList(List<WuShuIntroduction> introductionsList) {
        this.introductionsList = introductionsList;
    }

    public List<WuShuCulture> getCultureList() {
        return cultureList;
    }

    public void setCultureList(List<WuShuCulture> cultureList) {
        this.cultureList = cultureList;
    }

    public List<WuShuEssence> getEssenceList() {
        return essenceList;
    }

    public void setEssenceList(List<WuShuEssence> essenceList) {
        this.essenceList = essenceList;
    }

    @Override
    public String toString() {
        return "StudyTimingEntity{" +
                "speciesList=" + speciesList +
                ", introductionsList=" + introductionsList +
                ", cultureList=" + cultureList +
                ", essenceList=" + essenceList +
                '}';
    }
}
