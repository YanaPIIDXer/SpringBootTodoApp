package com.yanap.todoapp.controllers;

import java.util.ArrayList;
import java.util.List;

import com.yanap.todoapp.models.Todo;
import com.yanap.todoapp.models.User;
import com.yanap.todoapp.requests.TodoRequest;
import com.yanap.todoapp.requests.UserRequest;
import com.yanap.todoapp.services.TodoService;
import com.yanap.todoapp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// ユーザ関連コントローラ
@Controller
public class UserController {
    // ユーザサービス
    @Autowired
    UserService userService;

    // TODOサービス
    @Autowired
    TodoService todoService;

    // ユーザトップページ
    @RequestMapping("/user")
    public String index(Model model, @AuthenticationPrincipal User user) {
        List<Todo> todoList = todoService.collectByUserId(user.getId());
        model.addAttribute("todoList", todoList);
        model.addAttribute("request", new TodoRequest());
        return "user/index";
    }

    // 登録ページ
    @RequestMapping("/user/register")
    public String register(Model model) {
        model.addAttribute("request", new UserRequest());
        return "user/register";
    }

    // 登録処理
    @PostMapping("/user/register")
    public String registerAction(@Validated @ModelAttribute UserRequest request, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }
            model.addAttribute("request", request);
            model.addAttribute("errors", errors);
            return "user/register";
        }

        if (!userService.createFromRequest(request)) {
            List<String> errors = new ArrayList<String>();
            errors.add("何故か保存に失敗しました。");
            model.addAttribute("request", request);
            model.addAttribute("errors", errors);
            return "user/register";
        }
        return "redirect:/";
    }

    // ログインページ
    @RequestMapping("/user/login")
    public String login(Model model) {
        model.addAttribute("request", new UserRequest());
        return "user/login";
    }
}
