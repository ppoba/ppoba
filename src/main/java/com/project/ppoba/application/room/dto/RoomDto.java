package com.project.ppoba.application.room.dto;

import com.project.ppoba.application.room.Room;

import java.time.Duration;
import java.time.LocalDateTime;

public class RoomDto {
    public long roomId;
    public String title;
    public String status;
    public int leftTime; /* second */

    public RoomDto(Room room) {
        this.roomId = room.getId();
        this.title = room.getTitle();
        this.status = room.getStatus().getName();

        int timeLimit = room.getTimeLimit();
        LocalDateTime start = room.getRegDate();
        LocalDateTime end = start.plusSeconds(timeLimit);
        LocalDateTime now = LocalDateTime.now();

        int leftTime = (int) Duration.between(now, end).toSeconds();
        this.leftTime = leftTime <= 0 ? 0 : leftTime;
    }
}
