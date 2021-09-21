package com.yanap.todoapp.requests;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

// ユーザ新規登録・ログイン用リクエストデータ
public class UserRequest implements Serializable {
    // ユーザ名
    @NotEmpty(message = "名前を入力してください")
    private String name;

    // パスワード
    @NotEmpty(message = "パスワードを入力してください")
    private String password;

    // 各種アクセッサ
    // @HACK:lombokが仕事しないので自前でアクセッサ定義
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
