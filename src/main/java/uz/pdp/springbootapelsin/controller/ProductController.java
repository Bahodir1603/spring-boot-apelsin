package uz.pdp.springbootapelsin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.springbootapelsin.dto.ProductGTO;
import uz.pdp.springbootapelsin.repository.CategoryRepository;
import uz.pdp.springbootapelsin.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public String getAll(Model model){
        productService.getAll(model);
        return "product/list";
    }

    @GetMapping("/add")
    public String getAddPage(Model model){
        model.addAttribute("categoryList",categoryRepository.findAll());
        return "product/add";
    }

    @PostMapping("/add")
    public String getSavePage(Model model, @ModelAttribute ProductGTO product){
        productService.save(model,product);
        return "product/list";
    }
}
