package com.yanap.todoapp.controllers;

import java.util.ArrayList;
import java.util.List;

import com.yanap.todoapp.models.User;
import com.yanap.todoapp.models.Todo;
import com.yanap.todoapp.requests.TodoRequest;
import com.yanap.todoapp.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// TODO関係のコントローラ
@Controller
public class TodoController {
    // TODOサービス
    @Autowired
    TodoService todoService;

    // TODO追加
    @PostMapping("/todo/add")
    public String add(@Validated @ModelAttribute TodoRequest request, BindingResult result, Model model, @AuthenticationPrincipal User user) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }
            model.addAttribute("request", request);
            model.addAttribute("errors", errors);
            return "redirect:/user";
        }

        if (!todoService.createFromRequest(user.getId(), request)) {
            List<String> errors = new ArrayList<String>();
            errors.add("何故か保存に失敗しました。");
            model.addAttribute("request", request);
            model.addAttribute("errors", errors);
        }

        return "redirect:/user";
    }

    // 編集ページ
    @RequestMapping("/todo/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        Todo todo = todoService.getById(id);
        if (todo == null) {
            List<String> errors = new ArrayList<String>();
            errors.add("不正なIDです。");
            model.addAttribute("request", new TodoRequest());
            model.addAttribute("errors", errors);
            return "redirect: /user";
        }
        model.addAttribute("id", id);
        model.addAttribute("request", new TodoRequest(todo.getTitle(), todo.getBody(), todo.getPriority()));
        return "todo/edit";
    }

    // 更新処理
    @PostMapping("/todo/edit/update")
    public String update(@RequestParam("id") long id, @Validated @ModelAttribute TodoRequest request, BindingResult result, Model model) {
        Todo todo = todoService.getById(id);
        if (todo == null) {
            List<String> errors = new ArrayList<String>();
            errors.add("不正なIDです。");
            model.addAttribute("request", new TodoRequest());
            model.addAttribute("errors", errors);
            return "redirect: /user";
        }
        todo.setTitle(request.getTitle());
        todo.setBody(request.getBody());
        todo.setPriority(request.getPriority());
        if (!todoService.update(todo)) {
            List<String> errors = new ArrayList<String>();
            errors.add("何故か保存に失敗しました。");
            model.addAttribute("request", request);
            model.addAttribute("errors", errors);
            return "redirect:/user";
        }
        return "redirect:/user";
    }

    // 消去処理
    @PostMapping("/todo/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        if (!todoService.delete(id)) {
            List<String> errors = new ArrayList<String>();
            errors.add("何故か保存に失敗しました。");
            model.addAttribute("errors", errors);
        }
        return "redirect:/user";
    }
}
