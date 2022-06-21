package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String getAll(Model model) {
        categoryService.getAll(model);
        return "category/list";
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "category/add";
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute Category category, Model model){
        categoryService.add(model,category);
        return "category/list";
    }













}
