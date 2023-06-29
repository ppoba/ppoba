package com.project.ppoba.application.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<VoteInfo, Long> {
    List<VoteInfo> findAllByItemAndUuid(Item item, String uuid);

}
