package com.project.ppoba.application.room;

import com.project.ppoba.core.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoomController {

    @GetMapping("/room/test")
    public ApiResponse test(String name) {
        return ApiResponse.ok("hi " + name);
    }
}
