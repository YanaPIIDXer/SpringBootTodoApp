package com.yanap.todoapp.repositories;

import com.yanap.todoapp.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

// ユーザリポジトリ
public interface UserRepository extends JpaRepository<User, Integer> {   
    // 名前から検索
    public User findByName(String name);
}
