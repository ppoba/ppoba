package com.project.ppoba.application.room;

import lombok.Getter;

@Getter
public enum Status {
    IN_PROGRESS("진행중"),
    COMPLETE("완료"),
    TERMINATE("종료");

    private String name;

    Status(String name) { this.name = name; }
}
