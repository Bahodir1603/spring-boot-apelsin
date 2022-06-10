package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.springbootapelsin.entity.Customer;
import uz.pdp.springbootapelsin.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public String getAll(Model model) {
        customerService.getAll(model);
        return "customer/list"; //page nomi -> list.html templates
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "customer/add"; //page nomi -> list.html templates
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute Customer customer, Model model) {
        customerService.add(model, customer);
        return "customer/list";
    }
}