package com.yanap.todoapp.repositories;

import java.util.List;

import com.yanap.todoapp.models.Todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // 特定のユーザのTODOを列挙
    List<Todo> findByUserIdEquals(long userId);
}
