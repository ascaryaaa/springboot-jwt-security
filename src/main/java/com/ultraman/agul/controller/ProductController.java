package com.ultraman.agul.controller;

import com.ultraman.agul.model.Product;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        // In a real application, retrieve a list of products from a service or database
        List<Product> products = Arrays.asList(
            new Product(1L, "Laptop", 999.99),
            new Product(2L, "Smartphone", 499.99),
            new Product(3L, "Headphones", 79.99)
        );

        // Add the list of products to the model
        model.addAttribute("products", products);

        // Return the view name (Thymeleaf template name without the extension)
        return "product-list";
    }
}
