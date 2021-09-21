package com.yanap.todoapp.requests;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

// TODO管理用のリクエスト
@Data
@NoArgsConstructor
public class TodoRequest {
    // タイトル
    @NotEmpty(message = "タイトルを入力してください")
    private String title;
    
    // 本文
    @NotEmpty(message = "本文を入力してください")
    private String body;

    // 優先度
    private int priority;

    // フルコンストラクタ
    public TodoRequest(String title, String body, int priority) {
        this.title = title;
        this.body = body;
        this.priority = priority;
    }
}
