package com.example.java6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/Main")
    public String mainPage(){
        return "view/index";
    }
}
