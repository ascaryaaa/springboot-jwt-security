package com.ultraman.agul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public List<String> hello() {
        return List.of("ultraman", "batman", "superman");
    }
}
