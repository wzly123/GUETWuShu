package com.guet.wushu.service;

import java.util.List;
import java.util.Map;

/**
 * @author asus
 * 热搜的业务层
 */
public interface StudyTimingService {

    /**
     * 获取所有的点击数量
     * @return
     */
    List<Map.Entry<String, Integer>> getAllTimingInfo();
}
