package com.guet.wushu.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName WuShuIntroduction
 * @Author asus
 * @Version 1.0
 * @Description 武术介绍
 */
public class WuShuIntroduction implements Serializable {

    /**
     * id
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer iId;

    /**
     * 标题
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;

    /**
     * 内容
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String content;

    /**
     * 对应的武术学习id
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("study_id")
    private Integer studyId;

    /**
     * 创建时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 点击次数
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("click_times")
    private Integer clickTimes;

    public WuShuIntroduction() {
    }

    public WuShuIntroduction(Integer id) {
        this.iId = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStudyId() {
        return studyId;
    }

    public void setStudyId(Integer studyId) {
        this.studyId = studyId;
    }

    public Integer getClickTimes() {
        return clickTimes;
    }

    public void setClickTimes(Integer clickTimes) {
        this.clickTimes = clickTimes;
    }

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    @Override
    public String toString() {
        return "WuShuIntroduction{" +
                "iId=" + iId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", studyId=" + studyId +
                ", createTime=" + createTime +
                ", clickTimes=" + clickTimes +
                '}';
    }
}
