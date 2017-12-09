package com.test.config;

import com.test.interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class InterceptorConfig extends WebMvcConfigurerAdapter{
//加载拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截order/toOrder
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/order/toOrder");
        super.addInterceptors(registry);
    }
}
