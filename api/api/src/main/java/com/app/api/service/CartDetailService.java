package com.app.api.service;

import com.app.api.model.Cart;
import com.app.api.model.CartDetail;
import com.app.api.model.Product;
import com.app.api.repository.CartDetailRepository;
import com.app.api.repository.CartRepository;
import com.app.api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartDetailService {
    private final CartDetailRepository cartDetailRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartDetailService(CartDetailRepository cartDetailRepository, CartRepository cartRepository, ProductRepository productRepository) {
        this.cartDetailRepository = cartDetailRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public CartDetail addCartDetails(CartDetail cartDetail, int cartId, int productId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);
        cartDetail.setCart(cart);
        cartDetail.setProduct(product);
        return cartDetailRepository.save(cartDetail);
    }
}
