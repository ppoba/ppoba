package com.project.ppoba.application.room;

import com.project.ppoba.application.room.dto.RoomDetailDto;
import com.project.ppoba.application.room.dto.RoomDto;
import com.project.ppoba.core.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/room/create")
    public ApiResponse create(@RequestBody Map<String, Object> map) {
        String title = (String) map.get("title");
        int timeLimit = (int) map.get("timeLimit");

        long id = roomService.create(title, timeLimit);
        return ApiResponse.ok("roomId",id);
    }

    @GetMapping("/room/{roomId}")
    public ApiResponse get(@PathVariable long roomId) {
        Room room = roomService.findById(roomId);
        RoomDetailDto result = new RoomDetailDto(room);

        return ApiResponse.ok(result);
    }

    @GetMapping("/room/list")
    public ApiResponse list(Pageable pageable, String query) {
        Page<Room> roomList = roomService.list(pageable, query);
        List<RoomDto> result = roomList.stream()
                .map(RoomDto::new)
        .collect(Collectors.toList());

        return ApiResponse.ok("list",
                roomList.stream()
                        .map(RoomDto::new)
                        .collect(Collectors.toList())
        );

    }
}
