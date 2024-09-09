package com.KLBproject.KLB_project.service.Order;


import com.KLBproject.KLB_project.dto.OrderDto;
import com.KLBproject.KLB_project.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}