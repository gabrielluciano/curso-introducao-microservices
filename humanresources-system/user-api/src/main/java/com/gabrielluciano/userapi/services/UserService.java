package com.gabrielluciano.userapi.services;

import com.gabrielluciano.userapi.domain.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();
}
