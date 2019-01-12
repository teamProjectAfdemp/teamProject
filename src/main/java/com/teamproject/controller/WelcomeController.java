package com.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teamproject.bean.Users;

@Controller
public class WelcomeController {

    @GetMapping("index")
    public ModelAndView welcome(Users user) {
        return new ModelAndView("welcome");
    }
}
