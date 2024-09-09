package com.KLBproject.KLB_project.service.Cart;

import com.KLBproject.KLB_project.model.Cart;
import com.KLBproject.KLB_project.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}