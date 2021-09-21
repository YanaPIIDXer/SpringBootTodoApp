package com.yanap.todoapp.requests;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserRequest implements Serializable {
    @NotEmpty(message = "名前を入力してください")
    private String name;

    @NotEmpty(message = "パスワードを入力してください")
    private String password;
}
