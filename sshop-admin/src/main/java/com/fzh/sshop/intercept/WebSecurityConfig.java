package com.fzh.sshop.intercept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author fang
 * @date 2019/11/4 18:34
 **/
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    @Autowired
    public AuthInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(interceptor);
        addInterceptor.excludePathPatterns("/swagger/**");
        addInterceptor.addPathPatterns("/**");
    }


}