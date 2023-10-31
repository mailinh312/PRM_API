package com.app.api.repository;

import com.app.api.model.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductRepository extends ListCrudRepository<Product, Integer> {
    List<Product> findByCategory_Id(Integer id);
}
