package com.employeeApp.employeeApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("root")
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
