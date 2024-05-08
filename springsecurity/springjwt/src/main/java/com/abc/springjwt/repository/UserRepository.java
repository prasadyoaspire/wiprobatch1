package com.abc.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.springjwt.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

	Optional<UserEntity> findByUsernameOrEmail(String username,String email);
}
