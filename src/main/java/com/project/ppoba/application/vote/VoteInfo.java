package com.project.ppoba.application.vote;

import com.project.ppoba.application.item.Item;
import com.project.ppoba.core.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
//@Table(name = "VoteInfo")
public class VoteInfo extends BaseEntity {

    @NotNull
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "fk_VoteInfo_Item"))
    private Item item;
}
