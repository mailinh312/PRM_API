package com.app.api.api.controller.product;

import com.app.api.model.Product;
import com.app.api.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/c")
    public List<Product> getProductsByCategory(@RequestParam int cid) {
        return productService.getProductsByCategory_Id(cid);
    }

    @GetMapping("/p")
    public Optional<Product> getProductById(@RequestParam int id) {
        return productService.getProductById(id);
    }


}
