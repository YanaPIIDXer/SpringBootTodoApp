package com.yanap.todoapp.services;

import com.yanap.todoapp.models.User;
import com.yanap.todoapp.repositories.UserRepository;
import com.yanap.todoapp.requests.UserRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// ユーザサービス
@Service
public class UserService {

    // リポジトリ
    @Autowired
    private UserRepository repository;

    // パスワードエンコーダ
    @Autowired
    private PasswordEncoder passwordEncoder;

    // ユーザリクエストから生成
    public boolean createFromRequest(UserRequest request) {
        boolean result = false;
        String name = request.getName();
        String plainPassword = request.getPassword();
        String password = passwordEncoder.encode(plainPassword);
        User user = new User(name, password);
        try {
            result = (repository.save(user) != null);            
        } catch (Exception e) {
            result = false;
        }

        return result;
    }
    
}
