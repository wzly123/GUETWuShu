package com.guet.wushu.entity.configure;

import com.guet.wushu.entity.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Map;

/**
 * @ClassName InterceptorConfig
 * @Author asus
 * @Version 1.0
 * 拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/**")
                .excludePathPatterns("/api/v1/pri/login", "/api/v1/pri/register");

        WebMvcConfigurer.super.addInterceptors(registry);

    }
}
