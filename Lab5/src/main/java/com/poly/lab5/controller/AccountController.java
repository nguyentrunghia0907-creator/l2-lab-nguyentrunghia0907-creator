package com.poly.lab5.controller;

import com.poly.lab5.service.CookieService;
import com.poly.lab5.service.ParamService;
import com.poly.lab5.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    CookieService cs;
    @Autowired
    ParamService ps;
    @Autowired
    SessionService ss;

    @GetMapping("/account/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/account/login")
    public String loginAccount(){
        String un = ps.getString("username","");
        String pw = ps.getString("password","");
        boolean rm = ps.getBoolean("remember",false);

        if(un.equals("poly") && pw.equals("123")){
            ss.set("username", un);
            if(rm) {
                cs.add("user", un, 240);
            }else{
                cs.remove("user");
            }
            return "login";
        }else{
            cs.remove("user");
            return "login";
        }
    }
}
