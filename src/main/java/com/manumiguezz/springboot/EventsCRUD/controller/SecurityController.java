package com.manumiguezz.springboot.EventsCRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/public-events")
    public String showPublicEvents(){
        return "public/list-events-public";
    }
}
