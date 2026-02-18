package com.example.employee.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
