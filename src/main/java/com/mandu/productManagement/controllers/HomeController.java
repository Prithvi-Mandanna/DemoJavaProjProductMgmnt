package com.mandu.productManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login.jsp";
    }
    @RequestMapping("/logout")
    public String logoutPage(){
        return "logout.jsp";
    }
}

