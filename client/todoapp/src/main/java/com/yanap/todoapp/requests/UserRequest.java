package com.yanap.todoapp.requests;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

// ユーザ新規登録・ログイン用リクエストデータ
@Data
@NoArgsConstructor
public class UserRequest {
    // ユーザ名
    @NotEmpty(message = "名前を入力してください")
    private String name;

    // パスワード
    @NotEmpty(message = "パスワードを入力してください")
    private String password;
}
