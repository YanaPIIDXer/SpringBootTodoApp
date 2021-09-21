package com.yanap.todoapp;

import com.yanap.todoapp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// セキュリティ設定
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // ユーザサービス
    @Autowired
    private UserService userService;

    // セキュリティ設定
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // トップページと新規登録ページは認証無しでも入れる
        http.authorizeRequests()
            .antMatchers("/", "/user/register")
            .permitAll();
        
        // ログインページの指定
        http.formLogin()
            .loginPage("/user/login")
            .loginProcessingUrl("/user/auth")
            .usernameParameter("name")
            .passwordParameter("password")
            .defaultSuccessUrl("/user")
            .permitAll();
        
        // それ以外は認証が必要
        http.authorizeRequests()
            .anyRequest().authenticated();
    }
    
    // 認証設定
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
            .passwordEncoder(passwordEncoder());
    }

    // パスワードエンコーダ
    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
}
