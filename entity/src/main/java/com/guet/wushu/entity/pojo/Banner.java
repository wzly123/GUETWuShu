package com.guet.wushu.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName NewBanner
 * @Author asus
 * @Version 1.0
 * @Description 轮播图
 */
public class Banner implements Serializable {

    /**
     * id
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    /**
     * 名称
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    /**
     * 图片大小
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer weight;

    /**
     * 图片地址
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String url;

    /**
     * 创建时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public Banner() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "NewBanner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
