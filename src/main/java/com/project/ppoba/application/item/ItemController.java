package com.project.ppoba.application.item;

import com.project.ppoba.core.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item/create")
    public ApiResponse create(@RequestBody Map<String, Object> map) {
        long roomId = Long.valueOf(String.valueOf(map.get("roomId")));
        String name = (String) map.get("name");
        String resourceUri = (String) map.get("resourceUri");

        long itemId = itemService.create(roomId, name, resourceUri);
        return ApiResponse.ok("itemId", itemId);
    }

    @PostMapping("/item/vote")
    public ApiResponse vote(@RequestBody Map<String, Object> map) {
        long itemId = Long.valueOf(String.valueOf(map.get("itemId")));
        String uuid = (String) map.get("uuid");

        long voteId = itemService.vote(itemId, uuid);
        return ApiResponse.ok("voteId", voteId);
    }

}
