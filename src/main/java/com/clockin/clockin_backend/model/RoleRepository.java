package com.clockin.clockin_backend.model;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, String> {

    Role findByRole(String role);

}
