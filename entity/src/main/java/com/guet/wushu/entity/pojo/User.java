package com.guet.wushu.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Author asus
 * @Version 1.0
 * @Description 用户
 */
public class User implements Serializable {

    /**
     * id
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    /**
     * 昵称
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    /**
     * 真实姓名
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String realName;

    /**
     * 学号
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String studentId;

    /**
     * 电话号码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phoneNumber;

    /**
     * 密码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    private String pwd;

    /**
     * 个人介绍
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String introduction;

    /**
     * 学院
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String academy;

    /**
     * 专业
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String major;

    /**
     * 性别
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sex;

    /**
     * 创建时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", realName='" + realName + '\'' +
                ", studentId=" + studentId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pwd='" + pwd + '\'' +
                ", introduction='" + introduction + '\'' +
                ", academy='" + academy + '\'' +
                ", major='" + major + '\'' +
                ", sex='" + sex + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
