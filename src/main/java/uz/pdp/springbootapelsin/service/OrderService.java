package uz.pdp.springbootapelsin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.springbootapelsin.entity.Order;
import uz.pdp.springbootapelsin.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void getAll(Model model) {
        List<Order> orderList = orderRepository.findAll();
        model.addAttribute("list", orderList);
    }

    public void add(Model model, Order order) {
        orderRepository.save(order);
        model.addAttribute("list", orderRepository.findAll());
    }
}
