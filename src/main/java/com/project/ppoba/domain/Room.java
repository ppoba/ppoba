package com.project.ppoba.domain;

import com.project.ppoba.domain.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
//@Table(name = "Room")
public class Room extends BaseEntity {

    @NotNull
    private String title;

    @Column(columnDefinition = "integer default 0")
    private int timeLimit; // second

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Item> itemList;
}
