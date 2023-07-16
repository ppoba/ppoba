package com.project.ppoba.core.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApiResponse {
    private String message;
    private Object data;

    public static ApiResponse ok(Object data) {
        return new ApiResponse("success", data);
    }

    public static ApiResponse ok(String key, Object value) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, value);
        return new ApiResponse("success", map);
    }

    public static ApiResponse fail(Object data) {
        return new ApiResponse("fail", data);
    }
}
