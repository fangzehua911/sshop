package com.fzh.sshop.intercept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //TODO 放行指定 url
        if(UrlFilter.checkUrl(request.getRequestURI())){
            return true;
        }

        String token = request.getHeader("token");
        log.info("token : [ {} ]", token);
        //TODO  token校验  存在就放过


        log.info("拦截url:"+request.getRequestURI());
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("{\n" + "  \"code\": -9999,\n" + "  \"msg\": \"登录超时,请重新登录!\"\n" + "}");
        return false;
    }
}