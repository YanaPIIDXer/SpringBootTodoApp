package com.yanap.todoapp.requests;

import javax.validation.constraints.NotEmpty;

// TODO管理用のリクエスト
public class TodoRequest {
    // タイトル
    @NotEmpty(message = "タイトルを入力してください")
    private String title;
    
    // 本文
    @NotEmpty(message = "本文を入力してください")
    private String body;

    // 優先度
    private int priority;

    // デフォルトコンストラクタ
    public TodoRequest() {}

    // フルコンストラクタ
    public TodoRequest(String title, String body, int priority) {
        this.title = title;
        this.body = body;
        this.priority = priority;
    }

    // 各種アクセッサ
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
}
