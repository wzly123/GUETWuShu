package com.guet.wushu.entity.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guet.wushu.entity.pojo.User;
import com.guet.wushu.entity.utils.JWTUtils;
import com.guet.wushu.entity.utils.JsonData;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName LoginInterceptor
 * @Author asus
 * @Version 1.0
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 进入到Controller之前的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            String accessToken = request.getHeader("token");
            if (accessToken == null) {
                accessToken = request.getParameter("token");
            }

            if (!StringUtils.isEmpty(accessToken)){
                Claims claims = JWTUtils.checkJWT(accessToken);
                if (claims == null) {
                    //登录过期，重新登录
                    sendJsonMessage(response, JsonData.buildError("登录过期，请重新登录"));
                    return false;
                }



                Integer id = (Integer) claims.get("id");
                String name = (String) claims.get("name");


                String url = request.getRequestURI();

                /**
                 * 如果是更改用户信息的话不拦截
                 */
                if (url.endsWith("userInfo")){
                    return true;
                }
                /**
                 * 前端可以从发送的数据中获得相应的id，通过url拼接
                 * 就可以访问相应的用户信息
                 */
                sendJsonMessage(response,JsonData.buildSuccess(id));

                return true;
            }
        }catch (Exception e){}

        sendJsonMessage(response,JsonData.buildError("登录过期，请重新登录"));

        return false;
    }

    /**
     * application/json作为请求头告诉服务端消息主体是序列化的JSON字符串。
     * @param response
     * @param object
     */
    public static void sendJsonMessage(HttpServletResponse response, Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println(objectMapper.writeValueAsString(object));
            writer.close();
             ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
