package com.KLBproject.KLB_project.request;

import com.KLBproject.KLB_project.model.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateRequest {
    private Long id;

    @NotBlank(message = "Product name must be not blank")
    private String name;

    @NotBlank(message = "Product brand must be not blank")
    private String brand;

    @NotBlank(message = "Product price must be not blank")
    private BigDecimal price;

    @NotBlank(message = "Product inventory must be not blank")
    private int inventory;

    @NotBlank(message = "Product description must be not blank")
    private String description;

    @NotBlank(message = "Product category must be not blank")
    private Category category;
}