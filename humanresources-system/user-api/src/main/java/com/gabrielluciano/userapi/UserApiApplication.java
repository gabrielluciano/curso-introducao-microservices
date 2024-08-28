package com.gabrielluciano.userapi;

import com.gabrielluciano.userapi.domain.User;
import com.gabrielluciano.userapi.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository) {
        return args -> userRepository.saveAll(List.of(
                new User(null, "John", "john@email.com", "123", 20.0),
                new User(null, "Maria", "maria@email.com", "456", 21.0)
        ));
    }
}
