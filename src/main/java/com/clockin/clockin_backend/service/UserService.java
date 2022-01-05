package com.clockin.clockin_backend.service;

import com.clockin.clockin_backend.dto.UserDto;
import com.clockin.clockin_backend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> getUsers();

    User save(User user);

    Optional<User> find(Long id);
    User findByUsername(String username);

}
