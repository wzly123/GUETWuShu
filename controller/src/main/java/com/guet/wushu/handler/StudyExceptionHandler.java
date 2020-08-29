package com.guet.wushu.handler;

import com.guet.wushu.entity.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName StudyExceptionHandler
 * @Author asus
 * @Version 1.0
 * 对运行中的异常进行全局捕获
 */
@ControllerAdvice
public class StudyExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(StudyExceptionHandler.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e) {

        logger.error("[系统异常]{}",e.getMessage());

        if (e instanceof XDException) {

            XDException xdException = (XDException) e;

            return JsonData.buildError(xdException.getMsg());
        }else {

            return JsonData.buildError("全局异常，未知错误");

        }
    }
}
