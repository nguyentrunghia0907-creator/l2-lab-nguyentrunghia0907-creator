package com.poly.lab8.component;

import com.poly.lab8.entity.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        session.setAttribute("securityUri", uri);
        Account user = (Account) session.getAttribute("user");
        if(user == null) {
            response.sendRedirect("/auth/login");
            return false;

        }

        if(uri.equals("/admin/home/index") && Boolean.TRUE.equals(user.getAdmin())) {
            response.sendRedirect("/admin");
            return false;
        }

        if(uri.startsWith("/admin") && !Boolean.TRUE.equals(user.getAdmin())) {
            response.sendRedirect("/auth/login");
            return false;
        }
        return true;
    }
}
