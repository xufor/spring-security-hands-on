package com.assignment.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {	
}
