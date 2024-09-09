package com.KLBproject.KLB_project.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateUserRequest {

    @NotBlank(message = "First Name must be not blank")
    private String firstName;

    @NotBlank(message = "Last Name must be not blank")
    private String lastName;

    @Email(message = "Email invalid format")
    private String email;

    @NotBlank(message = "Password must be not blank")
    private String password;
}
