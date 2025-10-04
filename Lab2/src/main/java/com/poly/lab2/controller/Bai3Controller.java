package com.poly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.poly.lab2.controller.Product;


@Controller
public class Bai3Controller {
    @GetMapping("/bai3/form")
    public String form(){
        return "formBai3";
    }

    @PostMapping("/bai3/save")
    public String save (Product bean, Model model){
        model.addAttribute("name", bean.getName());
        model.addAttribute("price", bean.getPrice());
        return "formBai3";
    }
}
