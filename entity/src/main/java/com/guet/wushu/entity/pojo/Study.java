package com.guet.wushu.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Study
 * @Author asus
 * @Version 1.0
 * @Description 武术学习
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Study implements Serializable {

    /**
     * id
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

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

    /**
     * 创建时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Study() {
    }

    public Study(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }



    @Override
    public String toString() {
        return "Study{" +
                "id=" + id +
                ", speciesList=" + speciesList +
                ", introductionsList=" + introductionsList +
                ", cultureList=" + cultureList +
                ", essenceList=" + essenceList +
                ", createTime=" + createTime +
                '}';
    }
}
