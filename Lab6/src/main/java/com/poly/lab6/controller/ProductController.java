package com.poly.lab6.controller;

import com.poly.lab6.dao.CategoryDAO;
import com.poly.lab6.dao.OrderDAO;
import com.poly.lab6.dao.OrderDetailDAO;
import com.poly.lab6.dao.ProductDAO;
import com.poly.lab6.entity.Category;
import com.poly.lab6.entity.OrderDetail;
import com.poly.lab6.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductDAO dao;

    @Autowired
    OrderDetailDAO ddao;

    @Autowired
    CategoryDAO cdao;

    //Bài 3
    @RequestMapping("/product/sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {
        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("price"));
        List<Product> items = dao.findAll(sort);
        model.addAttribute("items", items);
        return "product/sort";
    }

    //Bài 4
    @RequestMapping("/product/page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findAll(pageable);
        model.addAttribute("page", page);
        return "product/page";
    }

    @RequestMapping("/product/index")
    public String index(Model model) {
        Product item = new Product();
        model.addAttribute("item", item);
        List<Product> items = dao.findAll();
        List<Category> listCategories = cdao.findAll();
        model.addAttribute("listCategories", listCategories);
        model.addAttribute("items", items);
        return "productCRUD/index";
    }

    @RequestMapping("/product/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Product item = dao.findById(id).get();
        model.addAttribute("item", item);
        List<Product> items = dao.findAll();
        model.addAttribute("items", items);
        List<Category> categories = cdao.findAll();
        model.addAttribute("categories", categories);
        return "productCRUD/index";
    }

    @RequestMapping("/product/create")
    public String create(Product item) {
        dao.save(item);
        return "redirect:product/index";
    }
    @RequestMapping("/product/update")
    public String update(Product item) {
        dao.save(item);
        return "redirect:/product/edit/" + item.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        ddao.deleteByProductId(id);
        dao.deleteById(id);
        return "redirect:product/index";
    }

}
