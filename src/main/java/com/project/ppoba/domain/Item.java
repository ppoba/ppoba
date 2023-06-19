package com.project.ppoba.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
//@AllArgsConstructor
//@Table(name = "Item")
public class Item extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", foreignKey = @ForeignKey(name = "fk_Item_Room"))
    private Room room;

    @NotNull
    private String name;

    private String resourceUri;
}
