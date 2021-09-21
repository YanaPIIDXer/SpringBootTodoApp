package com.yanap.todoapp.services;

import com.yanap.todoapp.models.User;
import com.yanap.todoapp.repositories.UserRepository;
import com.yanap.todoapp.requests.UserRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// ユーザサービス
@Service
public class UserService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.equals("")) { throw new UsernameNotFoundException("ユーザ名が空です"); }
        User user = repository.findByName(username);
        if (user == null) { throw new UsernameNotFoundException("ユーザ名かパスワードが間違っています"); }
        return user;
    }
    
}
