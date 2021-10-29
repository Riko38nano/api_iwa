package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    /**
     * index page
     * @return page reference
     */
    @GetMapping({"/", "/index"})
    public String home() {return "index";}

    @GetMapping("/login")
    public String login() {return "login";}

    @GetMapping("/changeUser")
    public String changeUser() {return "changeUser";}

    @GetMapping("listUsers")
    public String listUsers() {return "listUsers";}
}
