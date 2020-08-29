package com.guet.wushu.mapper;

import com.guet.wushu.entity.pojo.Study;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author asus
 * 武术学习mapper接口
 */
public interface StudyMapper {

    /**
     * 展示所有的武术学习内容
     * @param id
     * @return
     */
    Study displayAll(int id);

}
