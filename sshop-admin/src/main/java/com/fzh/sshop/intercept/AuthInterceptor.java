package com.fzh.sshop.intercept;

import com.fzh.sshop.config.jwt.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截请求校验 token
 */
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;

//        //TODO 放行指定 url
//        if(UrlFilter.checkUrl(request.getRequestURI())){
//            return true;
//        }
//       // TODO 校验TOKEN
//        String token = request.getHeader("token");
//        if(JWTUtil.verify(token)){
//            return true;
//        }
//
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json");
//        response.getWriter().println("{\n" + "  \"code\":"+ HttpStatus.UNAUTHORIZED.value()+",\n" + "  \"message\": \""+HttpStatus.UNAUTHORIZED.name()+"\"\n" + "}");
//        response.getWriter().flush();
//        return false;
    }
}