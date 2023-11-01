package com.app.api.api.controller.cart;

import com.app.api.model.CartDetail;
import com.app.api.repository.CartDetailRepository;
import com.app.api.service.CartDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order_detail")
public class CartDetailController {

    private final CartDetailService cartDetailService;

    public CartDetailController(CartDetailService cartDetailService) {
        this.cartDetailService = cartDetailService;
    }

    @PostMapping
    public CartDetail addCartDetails(@RequestBody CartDetail cartDetail, @RequestParam int cartId, @RequestParam int productId) {
        return cartDetailService.addCartDetails(cartDetail, cartId, productId);
    }
}
