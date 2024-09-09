package com.KLBproject.KLB_project.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserUpdateRequest {
    @NotBlank(message = "First Name must be not blank")
    private String firstName;

    @NotBlank(message = "Last Name must be not blank")
    private String lastName;
}