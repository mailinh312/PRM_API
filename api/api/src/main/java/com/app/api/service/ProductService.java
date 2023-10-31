package com.app.api.service;

import com.app.api.model.Product;
import com.app.api.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory_Id(int cid) {
        return productRepository.findByCategory_Id(cid);
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }
}
