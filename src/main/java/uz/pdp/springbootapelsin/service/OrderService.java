package uz.pdp.springbootapelsin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.springbootapelsin.dto.OrderGTO;
import uz.pdp.springbootapelsin.entity.Detail;
import uz.pdp.springbootapelsin.entity.Invoice;
import uz.pdp.springbootapelsin.entity.Order;
import uz.pdp.springbootapelsin.repository.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    DetailRepository detailRepository;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

//    public void getAll(Model model) {
//        List<Order> orderList = orderRepository.findAll();
//        model.addAttribute("list", orderList);
//    }


    public void add(OrderGTO orderGTO, Model model) {
        Order order = new Order();
        order.setCustomer(customerRepository.getById(orderGTO.getCustomerId()));
        order.setDate(new Date());
        Order save = orderRepository.save(order);

        Detail detail = new Detail();
        detail.setOrder(save);
        detail.setProduct(productRepository.getById(orderGTO.getProductId()));
        detail.setQuantity(orderGTO.getAmount());
        Detail detail1 = detailRepository.save(detail);

        Invoice invoice = new Invoice();
        invoice.setOrder(save);
        BigDecimal price = detail1.getProduct().getPrice();
        Short quantity = detail1.getQuantity();
        invoice.setAmount(price.multiply(BigDecimal.valueOf(quantity)));
        invoice.setDue(new Date());
        invoiceRepository.save(invoice);
//        model.addAttribute("list",orderRepository.findAll());
    }

}
