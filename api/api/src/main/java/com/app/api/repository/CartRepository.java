package com.app.api.repository;

import com.app.api.model.Cart;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface CartRepository extends ListCrudRepository<Cart, Integer> {
    @Override
    Optional<Cart> findById(Integer integer);
}
