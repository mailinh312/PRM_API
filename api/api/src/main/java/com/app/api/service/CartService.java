package com.app.api.service;

import com.app.api.model.Cart;
import com.app.api.model.CartDetail;
import com.app.api.model.User;
import com.app.api.repository.CartRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Cart addCart(Cart cart, @AuthenticationPrincipal User user){
        cart.setUser(user);
        return cartRepository.save(cart);
    }
}
