package com.project.ppoba.application.item;

import com.project.ppoba.core.BaseEntity;
import com.project.ppoba.application.room.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Item extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId", foreignKey = @ForeignKey(name = "fk_Item_Room"))
    private Room room;

    @NotNull
    private String name;

    private String resourceUri;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default()
    private List<VoteInfo> voteList = new ArrayList<>();

    public static Item of(Room room, String name, String resourceUri) {
        return Item.builder()
                .room(room)
                .name(name)
                .resourceUri(resourceUri)
                .build();
    }
}
