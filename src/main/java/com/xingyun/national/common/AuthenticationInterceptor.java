package com.xingyun.national.common;

import com.xingyun.national.entity.AdminUser;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 权限验证拦截器
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("---------------------开始进入请求地址拦截----------------------------");

        HttpSession session = request.getSession();
        AdminUser user = (AdminUser) session.getAttribute("user");

        if(user==null){
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView model) throws Exception {
        System.out.println("--------------处理请求完成后视图渲染之前的处理操作---------------");

        if(model!=null){
            AdminUser user = (AdminUser) request.getSession().getAttribute("user");
            if(user!=null){
                model.addObject("user",user);
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        System.out.println("---------------视图渲染之后的操作-------------------------");
    }
}