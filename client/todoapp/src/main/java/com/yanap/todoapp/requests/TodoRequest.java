package com.yanap.todoapp.requests;

// TODO管理用のリクエスト
public class TodoRequest {
    // タイトル
    private String title;
    
    // 本文
    private String body;

    // 優先度
    private int priority;

    // 各種アクセッサ
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
}
