package com.yanap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActionController {
    @RequestMapping("/")
    public String Index() {
        return "index";
    }    
}
