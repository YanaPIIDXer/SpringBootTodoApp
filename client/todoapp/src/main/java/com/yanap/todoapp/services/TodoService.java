package com.yanap.todoapp.services;

import java.util.List;

import com.yanap.todoapp.models.Todo;
import com.yanap.todoapp.repositories.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODOサービス
@Service
public class TodoService {
    // リポジトリ
    @Autowired
    private TodoRepository repository;

    // ユーザＩＤから列挙
    public List<Todo> collectByUserId(long userId) {
        return repository.findByUserIdEquals(userId);
    }
}
