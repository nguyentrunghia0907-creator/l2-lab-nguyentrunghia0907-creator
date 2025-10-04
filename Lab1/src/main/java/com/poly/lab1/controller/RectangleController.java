package com.poly.lab1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RectangleController {
    @RequestMapping("/rectangle/calculate")
    public String rectangle() {
        return "rectangle";
    }

    @Autowired
    HttpServletRequest req;

    @RequestMapping("/rectangle/excute")
    public String excute(Model model){
        int x = Integer.parseInt(req.getParameter("width"));
        int y = Integer.parseInt(req.getParameter("height"));
        model.addAttribute("area",  x + "*" + y + "=" + (x * y));
        model.addAttribute("perimeter", "(" + x + "+" + y +  ") * 2" + "=" + ((x + y)*2));
        return "rectangle";
    }
}
