package com.KLBproject.KLB_project.dto;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class CartItemDto {
    private Long itemId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private ProductDto product;
}