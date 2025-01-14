package com.KLBproject.KLB_project.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class LoginRequest {
    @Email(message = "Email invalid format")
    private String email;
    @NotBlank(message = "Password must be not blank")
    private String password;
}
