package com.app.api.api.controller.cart;

import com.app.api.model.Cart;
import com.app.api.model.User;
import com.app.api.service.CartService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getCarts();
    }

    @GetMapping("/oid")
    public Optional<Cart> findById(@RequestParam int id) {
        return cartService.findById(id);
    }

    @PostMapping
    public Cart addCart(@RequestBody Cart cart, @AuthenticationPrincipal User user){
        return cartService.addCart(cart, user);
    }
}
