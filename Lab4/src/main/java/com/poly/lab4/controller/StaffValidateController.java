package com.poly.lab4.controller;

import com.poly.lab4.entity.StaffValidate;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class StaffValidateController {
    @RequestMapping("/staff/create/formValidate")
    public String createForm(Model model, @ModelAttribute("staff") StaffValidate staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "staff-validate";
    }

    @RequestMapping("/staff/create/validate")
    public String save(@RequestPart("photo_file") MultipartFile photoFile,
                       @Valid @ModelAttribute("staff") StaffValidate staff,
                       Errors errors, Model model) {
        if(!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getName());
        }
        if(errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        }
        return "staff-validate";
    }
}
