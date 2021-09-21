package com.yanap.todoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// インデックスコントローラ
@Controller
public class IndexController {
    // トップページ
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
