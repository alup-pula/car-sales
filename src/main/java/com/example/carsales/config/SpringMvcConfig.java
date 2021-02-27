package com.example.carsales.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Bean
    public SessionInterceptor sessionInterceptor() {
        return new SessionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         /*addPathPatterns 用于添加拦截规则
         excludePathPatterns 用于排除拦截*/
        registry.addInterceptor(sessionInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/toLogin", "/login", "/assets/**", "/bootstrap/**", "/vendors/**");
    }

    /**
     * 静态资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }
}
