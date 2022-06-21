package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.springbootapelsin.dto.OrderGTO;
import uz.pdp.springbootapelsin.repository.CustomerRepository;
import uz.pdp.springbootapelsin.repository.OrderRepository;
import uz.pdp.springbootapelsin.repository.ProductRepository;
import uz.pdp.springbootapelsin.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderService orderService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("list", orderRepository.findAll());
        return "order/list"; //page nomi -> list.html templates
    }

    @GetMapping("/add")
    public String getAddPage(Model model) {
        model.addAttribute("customerList",customerRepository.findAll());
        model.addAttribute("productList",productRepository.findAll());
        return "order/add";
    }

//    @PostMapping("/add")
//    public String saveAddPage(@ModelAttribute OrderGTO orderGTO,Model model){
//        orderService.add(orderGTO,model);
//        model.addAttribute("list",orderRepository.findAll());
//        return "order/list";
//    }
    @PostMapping("/add")
    public String savePage(Model model, OrderGTO order){
        orderService.add(order,model);
        model.addAttribute("list",orderRepository.findAll());
        return "order/list";
    }
}