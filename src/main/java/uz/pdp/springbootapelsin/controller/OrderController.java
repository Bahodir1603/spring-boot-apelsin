package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.springbootapelsin.entity.Order;
import uz.pdp.springbootapelsin.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public String getAll(Model model) {
        orderService.getAll(model);
        return "order/list"; //page nomi -> list.html templates
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "order/add"; //page nomi -> list.html templates
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute Order order, Model model) {
        orderService.add(model, order);
        return "order/list";
    }
}