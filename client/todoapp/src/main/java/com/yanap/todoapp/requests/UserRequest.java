package com.yanap.todoapp.requests;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.yanap.todoapp.models.User;

import lombok.Data;

@Data
public class UserRequest implements Serializable {
    @NotEmpty(message = "名前を入力してください")
    private String name;

    @NotEmpty(message = "パスワードを入力してください")
    private String password;

    // ユーザを生成
    public User createUser() {
        // @TODO:パスワードは暗号化する
        return new User(name, password);
    }
}
