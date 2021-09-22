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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
        // 認証無しでもアクセス可能
        // ※トップページ、登録ページ、リソースファイル
        http.authorizeRequests()
            .antMatchers("/", "/user/register", "/css/**", "/js/**")
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

        // ログアウト
        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
            .logoutUrl("/user/logout")
            .logoutSuccessUrl("/");
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
