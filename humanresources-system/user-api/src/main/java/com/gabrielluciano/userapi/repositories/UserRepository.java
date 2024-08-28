package com.gabrielluciano.userapi.repositories;

import com.gabrielluciano.userapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
