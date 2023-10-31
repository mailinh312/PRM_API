package com.app.api.repository;

import com.app.api.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends ListCrudRepository<Product, Integer> {
    List<Product> findByCategory_Id(Integer id);


    @Transactional
    @Query("select new Product (p.id, p.productName, p.price, p.imageUrl) from Product p")
    List<Product> findAllProducts();

}
