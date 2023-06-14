package com.project.ppoba.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    @GetMapping ("/test")
    public String test(String name) {

        return "hi " + name;
    }

}
