package com.yanap.todoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    // トップページ
    @RequestMapping("/")
    public String Index() {
        return "index";
    }
}