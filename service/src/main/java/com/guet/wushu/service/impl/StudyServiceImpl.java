package com.guet.wushu.service.impl;

import com.guet.wushu.entity.pojo.Study;
import com.guet.wushu.mapper.StudyMapper;
import com.guet.wushu.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.ImageConsumer;

/**
 * @ClassName StudyService
 * @Author asus
 * @Version 1.0
 */
@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    private StudyMapper mapper;

    @Override
    public Study studyDisplay(int id) {
        return mapper.displayAll(id);
    }
}
