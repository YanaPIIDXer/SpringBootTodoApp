package com.yanap.todoapp.repositories;

import com.yanap.todoapp.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {   
}
