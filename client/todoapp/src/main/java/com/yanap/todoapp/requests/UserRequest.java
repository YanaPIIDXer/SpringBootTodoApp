package com.yanap.todoapp.requests;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.yanap.todoapp.models.User;

// ユーザ新規登録・ログイン用リクエストデータ
public class UserRequest implements Serializable {
    @NotEmpty(message = "名前を入力してください")
    private String name;

    @NotEmpty(message = "パスワードを入力してください")
    private String password;

    // @HACK:lombokが仕事しないので自前でアクセッサ定義
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // ユーザを生成
    public User createUser() {
        // @TODO:パスワードは暗号化する 
        return new User(name, password);
    }
}
