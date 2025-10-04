package com.poly.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/poly/hello")
    public String hello(Model model) {
        model.addAttribute("title", "Fpt Polytechnic");
        model.addAttribute("subject", "Java 5");
        return "hello.html";
    }
}
