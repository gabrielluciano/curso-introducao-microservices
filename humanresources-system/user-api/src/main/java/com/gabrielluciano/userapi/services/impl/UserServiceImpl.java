package com.gabrielluciano.userapi.services.impl;

import com.gabrielluciano.userapi.domain.User;
import com.gabrielluciano.userapi.repositories.UserRepository;
import com.gabrielluciano.userapi.services.UserService;
import com.gabrielluciano.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
