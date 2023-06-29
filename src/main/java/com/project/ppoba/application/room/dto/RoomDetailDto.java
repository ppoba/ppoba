package com.project.ppoba.application.room.dto;

import com.project.ppoba.application.room.Room;

import java.util.List;
import java.util.stream.Collectors;

public class RoomDetailDto extends RoomDto {
    public int headCount;
    public List<ItemDetailDto> itemList;

    public RoomDetailDto(Room room) {
        super(room);
        this.headCount = 0; // todo: @syk; uuid distinct 해서 투표 참여인원 가져오기
        this.itemList = room.getItemList().stream()
                // room.getStatus != Status.IN_PROGRESS -> sort
                .map(ItemDetailDto::new)
                .collect(Collectors.toList());
    }
}
