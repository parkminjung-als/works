package com.example.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByPlatformId(String platformId);
    Optional<User> findByEmail(String email);
}
