package com.poly.lab1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping("/login/form")
    public String form(){
        return "login.html";
    }

    @Autowired
    HttpServletRequest req;

    @RequestMapping(value = "/login/check", method = RequestMethod.POST)
    public String check(Model model) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("poly".equals(username) && "123".equals(password)) {
            model.addAttribute("message",  "Đăng nhập thành công" + username );
        } else {
            model.addAttribute("message", "Sai thông tin");
        }
        return "login.html";
    }
}
