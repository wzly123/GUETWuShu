package com.guet.wushu.service;

import java.util.List;
import java.util.Map;

/**
 * @author asus
 * @param <T>
 * 武术学习的公共接口
 */
public interface StudyCommonService<T> {

    /**
     * 查看信息
     * @param id
     * @return
     */
    T selectByTd(int id);

    /**
     * 展示所有的信息
     * @return
     */
    List<T> displayInfo();

    /**
     * 更改点击数
     * @param t
     * @return
     */
    int updateNewClickRecord(T t);

    /**
     * 插入新的信息
     * @param info
     * @return
     */
    int insertInfo(Map<String,String> info);

    /**
     * 删除信息
     * @param ids
     * @return
     */
    Boolean deleteInfo(String ids);

    /**
     * 更改信息
     * @param info
     * @return
     */
    int updateInfo(Map<String,String> info);
}
