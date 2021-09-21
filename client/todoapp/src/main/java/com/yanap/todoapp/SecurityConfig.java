package com.yanap.todoapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// セキュリティ設定
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
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
}
