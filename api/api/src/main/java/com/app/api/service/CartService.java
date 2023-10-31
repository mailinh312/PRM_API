package com.app.api.service;

import com.app.api.model.Cart;
import com.app.api.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> findById(int id) {
        return cartRepository.findById(id);
    }
}
