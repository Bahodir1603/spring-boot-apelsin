package uz.pdp.springbootapelsin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.springbootapelsin.entity.Product;
import uz.pdp.springbootapelsin.dto.ProductGTO;
import uz.pdp.springbootapelsin.repository.CategoryRepository;
import uz.pdp.springbootapelsin.repository.ProductRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public void getAll(Model model) {
        model.addAttribute("list", productRepository.findAll());
    }

    public void save(Model model, ProductGTO productGTO) {
        Product product = new Product();
        product.setDescription(productGTO.getDescription());
        product.setName(productGTO.getName());
        product.setPrice(BigDecimal.valueOf(productGTO.getPrice()));
        product.setCategory(categoryRepository.getById(productGTO.getCatId()));
        productRepository.save(product);
        model.addAttribute("list",productRepository.findAll());
    }
}
