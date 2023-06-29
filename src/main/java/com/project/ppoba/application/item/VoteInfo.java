package com.project.ppoba.application.item;

import com.project.ppoba.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class VoteInfo extends BaseEntity {

    @NotNull
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId", foreignKey = @ForeignKey(name = "fk_VoteInfo_Item"))
    private Item item;

    public static VoteInfo of(String uuid, Item item) {
        return VoteInfo.builder()
                .uuid(uuid)
                .item(item)
                .build();
    }
}
