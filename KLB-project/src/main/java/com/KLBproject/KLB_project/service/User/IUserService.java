package com.KLBproject.KLB_project.service.User;

import com.KLBproject.KLB_project.dto.UserDto;
import com.KLBproject.KLB_project.model.User;
import com.KLBproject.KLB_project.request.CreateUserRequest;
import com.KLBproject.KLB_project.request.UserUpdateRequest;

public interface IUserService {

    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);

    User getAuthenticatedUser();
}
