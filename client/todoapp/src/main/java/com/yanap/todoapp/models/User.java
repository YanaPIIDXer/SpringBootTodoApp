package com.yanap.todoapp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String password;

    // コンストラクタ
    // IDは自動生成されるので省略
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
