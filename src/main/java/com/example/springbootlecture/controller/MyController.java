package com.example.springbootlecture.controller;

import com.example.springbootlecture.config.MyConfig;
import com.example.springbootlecture.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {
    private final MyService myService;
    private final MyConfig myConfig;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}