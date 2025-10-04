package com.poly.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StaffController {
    //Bài 1
    @RequestMapping("/staff/detail")
    public String detail(Model model) {
        Staff staff = Staff.builder().id("user@gmail.com").fullname("nguyễn văn user").level(2).build();
        model.addAttribute("staff", staff);
        return "staff-detail";
    }

    public List<Staff> getStaffSample(){
        return List.of(
            Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").level(0).build(),
            Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").level(1).build(),
            Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").level(2).build(),
            Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
            Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
            Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build());
    }

//Bài 2
    @RequestMapping("/staff/list")
    public String list(Model model) {
        model.addAttribute("list", getStaffSample());
        return "staff-list";
    }
//Bài 4
    @RequestMapping("/staff/table")
    public String table(Model model) {
        model.addAttribute("list", getStaffSample());
        return "staff-table";
    }
//Bài 5
    @RequestMapping("/staff/selectBox")
    public String selectBox(Model model) {
        model.addAttribute("list", getStaffSample());
        return "staff-selectBox";
    }
}
