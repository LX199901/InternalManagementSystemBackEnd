package com.ims.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // 允许所有路径
                        .allowedOriginPatterns("*")  // 允许所有来源
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")  // 允许的HTTP方法
                        .allowedHeaders("*")  // 允许所有头
                        .allowCredentials(true)  // 允许凭证
                        .maxAge(3600);  // 预检请求的缓存时间
            }
        };
    }
}
