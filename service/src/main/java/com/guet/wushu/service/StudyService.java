package com.guet.wushu.service;

import com.guet.wushu.entity.pojo.Study;

/**
 * @author asus
 * 武术学习中的业务层
 */
public interface StudyService {

    /**
     * 展示武术学习中的所有模块
     * @param id
     * @return
     */
    Study studyDisplay(int id);
}
