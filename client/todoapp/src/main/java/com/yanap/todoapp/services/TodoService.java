package com.yanap.todoapp.services;

import java.util.List;

import com.yanap.todoapp.models.Todo;
import com.yanap.todoapp.repositories.TodoRepository;
import com.yanap.todoapp.requests.TodoRequest;

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

    // リクエストから作成
    public boolean createFromRequest(long userId, TodoRequest request) {
        boolean result = false;
        Todo todo = new Todo(userId, request.getTitle(), request.getBody(), request.getPriority());
        try {
            result = (repository.save(todo) != null);
        } catch(Exception e) {
            result = false;
        }
        return result;
    }
}
