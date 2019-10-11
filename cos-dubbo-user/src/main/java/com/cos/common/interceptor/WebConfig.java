package com.cos.common.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/8/30 9:55
 * @Classname: WebConfig
 * @To change this template use File | Settings | File Templates.
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    public ClientIpInterceptor clientIpInterceptor() {
        return new ClientIpInterceptor();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(clientIpInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
