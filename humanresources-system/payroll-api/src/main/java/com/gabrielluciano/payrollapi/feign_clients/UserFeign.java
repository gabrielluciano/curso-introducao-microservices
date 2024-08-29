package com.gabrielluciano.payrollapi.feign_clients;

import com.gabrielluciano.payrollapi.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-api")
public interface UserFeign {

    @GetMapping("/api/users/{id}")
    ResponseEntity<User> findById(@PathVariable Long id);

    @GetMapping("/api/users")
    ResponseEntity<List<User>> findAll();
}
