package com.coldsmog.luckinmap.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: admin 注册拦截器
 * @Author: quanhuan.huang
 * @Date: 2019/10/29 14:34
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Autowired
    private AdminInterceptor reactInterceptor;

    /**
     * 添加拦截器
     *
     * @param registry 拦截器注册表
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //需要添加多个拦截器的话，调用addInterceptor()多次即可
        registry.addInterceptor(reactInterceptor)
                //拦截器要拦截的url规则
                .addPathPatterns("/**")
                //拦截器屏蔽的url规则
                .excludePathPatterns("/admin/login", "/admin/logout", "/api/admin/member/getCaptcha", "/admin/updatePassword", "/**/*.css", "/**/*.js",
                        "/**/*. png ", "/**/*.jpg", "/**/*.jpeg ",
                        "/*.html", "/**/*.html", "/swagger-resources/**",
                        "/upload")
                // 拦截器的执行顺序
                .order(1);
    }

}
