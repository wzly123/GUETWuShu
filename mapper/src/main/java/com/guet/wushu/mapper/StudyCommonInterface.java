package com.guet.wushu.mapper;

import com.guet.wushu.entity.pojo.WuShuCulture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author asus
 * 武术学习中共同部分的mapper接口
 */
public interface StudyCommonInterface<T> {

    /**
     * 通过信息中的StudyId查找相应的信息
     * @param id
     * @return
     */
    List<T> selectInfoByStudyId(int id);

    /**
     * 通过信息中的Id查找相应的信息
     * @param id
     * @return
     */
    T selectInfoById(int id);

    /**
     * 改变信息中的点击数
     * @param t
     * @return
     */
    int updateNewClickRecord(T t);

    /**
     * 查看信息中的所有信息
     * @return
     */
    List<T> selectAll();

    /**
     * 插入一条新的内容
     * @param t
     * @return
     */
    int insertNewContent(T t);

    /**
     * 更改信息中的内容
     * @param t
     * @return
     */
    int updateInfo(T t);

    /**
     * 根据id删除相应的信息
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") String[] ids);
}
