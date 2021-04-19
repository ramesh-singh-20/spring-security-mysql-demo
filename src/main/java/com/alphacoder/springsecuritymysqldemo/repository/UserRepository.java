package com.alphacoder.springsecuritymysqldemo.repository;

import com.alphacoder.springsecuritymysqldemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findUserByUsername(String username);
}
