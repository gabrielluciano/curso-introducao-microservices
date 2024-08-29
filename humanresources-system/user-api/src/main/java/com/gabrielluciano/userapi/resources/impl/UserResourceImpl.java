package com.gabrielluciano.userapi.resources.impl;

import com.gabrielluciano.userapi.domain.User;
import com.gabrielluciano.userapi.resources.UserResource;
import com.gabrielluciano.userapi.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserResourceImpl implements UserResource {

    private final UserService service;
    private final Environment env;

    @Override
    public ResponseEntity<User> findById(Long id) {
        log.info("USER_SERVICE ::: Get by id request on {} port", env.getProperty("local.server.port"));
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        log.info("USER_SERVICE ::: Get all request on {} port", env.getProperty("local.server.port"));
        return ResponseEntity.ok(service.findAll());
    }
}
