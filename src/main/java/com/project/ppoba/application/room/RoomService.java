package com.project.ppoba.application.room;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomService {
    private final RoomRepository roomRepository;

    public long create(String title, int timeLimit) {
        Room room = Room.of(title, timeLimit);
        long roomId = roomRepository.save(room).getId();

        return roomId;
    }
    public Page<Room> list(Pageable pageable, String query) {
        return roomRepository.findByTitleContains(pageable, query);
    }

    public Room findById(long roomId) {
        return roomRepository.findById(roomId).orElseThrow();
    }
}
