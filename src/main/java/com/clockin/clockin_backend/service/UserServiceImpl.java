package com.clockin.clockin_backend.service;

import com.clockin.clockin_backend.dto.UserDto;
import com.clockin.clockin_backend.model.User;
import com.clockin.clockin_backend.model.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getUsers() {
        var list = new ArrayList<UserDto>();
        for(var user : userRepository.findAll()) {
            list.add(new UserDto(user.getId(), user.getFirstName(), user.getLastName()));
        }
        return list;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public Optional<User> find(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
