package com.clockin.clockin_backend.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findUserRoleById(Long id);

    UserRole findUserRoleByRole(String role);
}
