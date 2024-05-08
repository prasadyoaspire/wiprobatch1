package com.abc.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.springjwt.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity,Long>{

}
