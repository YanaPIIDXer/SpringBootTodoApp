package com.yanap.todoapp.controllers;

import com.yanap.todoapp.requests.TodoRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// TODO関係のコントローラ
@Controller
public class TodoController {
    @PostMapping("/todo/add")
    public String add(@Validated @ModelAttribute TodoRequest request, BindingResult result, Model model) {
        System.out.println("Title:" + request.getTitle());
        return "redirect:/user";
    }
}
