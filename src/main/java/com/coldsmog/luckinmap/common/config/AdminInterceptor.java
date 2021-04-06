package com.coldsmog.luckinmap.common.config;

import com.coldsmog.luckinmap.common.constants.AdminConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: admin统一拦截 token
 * @Author: quanhuan.huang
 * @Date: 2019/10/29 14:34
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {


        Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            // 如果不是映射到方法直接通过
            if (!(handler instanceof HandlerMethod)) {
                return true;
            }
            // 从 http 请求头中取出 token
            String token = request.getHeader(AdminConstant.TOKEN);
            // 设置response的返回格式
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");

            return true;
    }
}
