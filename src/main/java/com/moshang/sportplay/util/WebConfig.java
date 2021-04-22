package com.moshang.sportplay.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: 全局配置类--配置跨域请求
 * @Auther: Yu
 * @Date: 2021/4/1 11:29
 */

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         * 1.域访问路径
         * 2.请求来源
         * 3.方法
         * 4.允许携带（像tocken...）
         * 5.最大时间，生命周期
         */
        registry.addMapping("/**")
                .allowedOrigins("Http://localhost:8080","null")
                .allowedMethods("GET","POST","PUT","OPTIONS","DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
