package com.example.carsales.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义
 * 访问权限控制
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String name = (String) request.getSession().getAttribute("name");
        //如果session中的name为空，返回登录界面
        if (name == null) {
            response.sendRedirect(request.getContextPath() + "/toLogin");
            return false;
        }
        String uri = request.getRequestURI().toLowerCase();
        //uri中是否包含用户管理访问路径
        if (uri.contains("user")) {
            //判断访问用户是否为admin
            Long id = (Long) request.getSession().getAttribute("uid");
            if (id != 1) {
                response.sendRedirect(request.getContextPath() + "/index");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
