package com.yanap.todoapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

// TODOモデル
@Entity
@Data
@NoArgsConstructor
@Table(name = "todos")
public class Todo {
    @Id
    @Column
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private int priority;

    // デフォルトコンストラクタ
    public Todo() {}

    // コンストラクタ
    public Todo(long userId, String title, String body, int priority) {
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.priority = priority;
    }
}
