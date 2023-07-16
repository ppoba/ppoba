package com.project.ppoba.application.room;

import com.project.ppoba.application.item.Item;
import com.project.ppoba.core.BaseEntity;
import com.project.ppoba.core.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Room extends BaseEntity {

    @NotNull
    private String title;

    @Column(columnDefinition = "integer default 0")
    private int timeLimit; // second

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default()  private List<Item> itemList = new ArrayList<>();

    public static Room of(String title, int timeLimit) {
        return  Room.builder()
                .title(title)
                .timeLimit(timeLimit)
                .status(Status.IN_PROGRESS)
                .build();
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

}
