package com.project.ppoba.application.room.dto;

import com.project.ppoba.application.item.Item;

public class ItemDetailDto {
    public long itemId;
    public String name;
    public int voteCount;
    public String imageUrl;

    public ItemDetailDto(Item item) {
        this.itemId = item.getId();
        this.name = item.getName();
        this.imageUrl = item.getResourceUri();
        this.voteCount = item.getVoteList().size();
    }
}
