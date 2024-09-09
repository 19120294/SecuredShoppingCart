package com.KLBproject.KLB_project.repository;

import com.KLBproject.KLB_project.model.Role;
import com.KLBproject.KLB_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String role);
}
