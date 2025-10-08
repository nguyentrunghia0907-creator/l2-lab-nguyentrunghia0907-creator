package com.poly.lab5.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {
    @Autowired
    HttpServletRequest req;

    @Autowired
    HttpServletResponse resp;

    public Cookie get(String name){
        Cookie[] cookies = req.getCookies();
        if(cookies == null){
            return null;
        }
        for(Cookie c : cookies){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public String getValue(String name){
        Cookie c = get(name);
        if(c != null){
            return "";
        }else{
            return c.getValue();
        }
    }

    public Cookie add(String name, String value, int hours){
        Cookie c = new Cookie(name, value);
        c.setPath("/");
        c.setMaxAge(hours * 3600);
        c.setHttpOnly(true);
        resp.addCookie(c);
        return c;
    }

    public void remove(String name){
        Cookie c = new Cookie(name, "");
        c.setPath("/");
        c.setMaxAge(0);
        resp.addCookie(c);
    }
}
