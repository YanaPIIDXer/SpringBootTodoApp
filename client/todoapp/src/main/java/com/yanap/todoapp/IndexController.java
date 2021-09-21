package com.yanap.todoapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    // トップページ
    @RequestMapping("/")
    public String Index() {
        return "index";
    }

    // 登録ページ
    // @TODO:後でUserControllerでも定義してそっちに移す
    @RequestMapping("/user/register")
    public String Register() {
        return "user/register";
    }
}
