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
    
    // 各種アクセッサ
    public long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
}
