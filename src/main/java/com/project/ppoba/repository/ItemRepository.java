package com.project.ppoba.repository;

import com.project.ppoba.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Room, Long> {

}
