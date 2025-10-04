package com.poly.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    @GetMapping("/product/form")
    public String form(Model model){
        Product p = new Product();
        p.setName("IPhone 10");
        p.setPrice(5000.0);
        model.addAttribute("product1",p);
        model.addAttribute("product2",new Product());
        return "formProduct";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product2") Product p, Model model){
        model.addAttribute("product1", new Product("IPhone 10", 5000.0));
        products.add(new Product(p.name, p.price));
        return "formProduct";
    }

    private List<Product> products = new ArrayList<>(
        Arrays.asList(new Product("A", 1), new Product("B", 12))
    );

    @ModelAttribute("items")
    public List<Product> getItems() {
        return products;
    }
}
