package com.student.controllers;


import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class OurController {

    @GetMapping("/hello")
    public String helloPage(){
        return "views/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "views/goodbye";
    }
}
