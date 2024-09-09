package com.KLBproject.KLB_project.controller;

import com.KLBproject.KLB_project.dto.UserDto;
import com.KLBproject.KLB_project.exceptions.AlreadyExistsException;
import com.KLBproject.KLB_project.exceptions.ResourceNotFoundException;
import com.KLBproject.KLB_project.model.User;
import com.KLBproject.KLB_project.request.CreateUserRequest;
import com.KLBproject.KLB_project.request.UserUpdateRequest;
import com.KLBproject.KLB_project.response.ApiResponse;
import com.KLBproject.KLB_project.response.ResponseData;
import com.KLBproject.KLB_project.response.ResponseError;
import com.KLBproject.KLB_project.service.User.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/users")
@Tag(name="User Controller")
public class UserController {
    private final IUserService userService;

    @Operation(summary = "Get user by id", description = "API get user by id")
    @GetMapping("/{userId}/user")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long userId) {
        try {
            User user = userService.getUserById(userId);
            UserDto userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("Success", userDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }


//    @Operation(summary = "Add user", description = "API create new user")
//    @PostMapping("/add")
//    public ResponseEntity<ApiResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
//        try {
//            User user = userService.createUser(request);
//            UserDto userDto = userService.convertUserToDto(user);
//            return ResponseEntity.ok(new ApiResponse("Create User Success!", userDto));
//        } catch (AlreadyExistsException e) {
//            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
//        }
//    }
    @Operation(summary = "Add user", description = "API create new user")
    @PostMapping("/add")
    public ResponseData<UserDto> createUser(@Valid @RequestBody CreateUserRequest request) {
        try {
            User user = userService.createUser(request);
            UserDto userDto = userService.convertUserToDto(user);
            return new ResponseData<>(HttpStatus.CREATED.value(),"Create User Success!",userDto);
        } catch (AlreadyExistsException e) {
            return new ResponseError(CONFLICT.value(), e.getMessage());
        }
    }



    @Operation(summary = "Update user  by ID", description = "API update user by id")
    @PutMapping("/{userId}/update")
    public ResponseEntity<ApiResponse> updateUser(@Valid @RequestBody UserUpdateRequest request, @PathVariable Long userId) {
        try {
            User user = userService.updateUser(request, userId);
            UserDto userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("Update User Success!", userDto));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @Operation(summary = "Delete user by id", description = "API delete user by id")
    @DeleteMapping("/{userId}/delete")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok(new ApiResponse("Delete User Success!", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
