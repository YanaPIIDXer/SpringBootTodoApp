package com.yanap.todoapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// セキュリティ設定
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 設定
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // トップページと新規登録ページは認証無しでも入れる
        http.authorizeRequests()
            .antMatchers("/", "/user/register")
            .permitAll();
        
        // ログインページの指定
        http.formLogin()
            .loginPage("/user/login")
            .permitAll();
        
        // それ以外は認証が必要
        http.authorizeRequests()
            .anyRequest().authenticated();
    }

    // パスワードエンコーダ
    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
}
