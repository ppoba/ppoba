package com.project.ppoba.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApiResponse {
    private String message;
    private Object data;

    public static ApiResponse ok(Object data) {
        return new ApiResponse("success", data);
    }

    public static ApiResponse fail(Object data) {
        return new ApiResponse("fail", data);
    }
}
