package com.app.api.api.controller.cart;

import com.app.api.model.Cart;
import com.app.api.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
