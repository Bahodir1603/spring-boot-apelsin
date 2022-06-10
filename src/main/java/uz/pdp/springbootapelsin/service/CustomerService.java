package uz.pdp.springbootapelsin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.springbootapelsin.entity.Customer;
import uz.pdp.springbootapelsin.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void getAll(Model model) {
        List<Customer> customerList = customerRepository.findAll();
        model.addAttribute("list", customerList);
    }

    public void add(Model model, Customer customer) {
        customerRepository.save(customer);
        model.addAttribute("list", customerRepository.findAll());
    }
}
