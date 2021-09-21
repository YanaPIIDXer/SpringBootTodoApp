package com.yanap.todoapp.services;

import com.yanap.todoapp.models.User;
import com.yanap.todoapp.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// ユーザサービス
@Service
public class UserService {

    // リポジトリ
    @Autowired
    private UserRepository repository;

    // 保存
    public boolean save(User user) {
        return (repository.save(user) != null);
    }
    
}
