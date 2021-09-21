package com.yanap.todoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    // 登録ページ
    @RequestMapping("/user/register")
    public String Register() {
        return "user/register";
    }
}
