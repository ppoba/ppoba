package com.project.ppoba.controller;

import com.project.ppoba.core.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    @GetMapping ("/test")
    public ApiResponse test(String name) {

        return ApiResponse.ok("hi " + name);
    }
}
