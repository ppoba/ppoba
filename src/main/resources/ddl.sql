CREATE TABLE room (
    id         bigint auto_increment primary key,
    time_limit int default 0 null,
    title      varchar(255)  not null,
    reg_date   datetime(6)   null,
    status     varchar(255)  not null
);

CREATE TABLE item (
    id           bigint auto_increment primary key,
    room_id      bigint       null,
    name         varchar(255) not null,
    resource_uri varchar(255) null,
    reg_date     datetime(6)  null,

    constraint fk_Item_Room foreign key (room_id) references ppoba.room (id)
);

CREATE TABLE vote_info (
    id       bigint auto_increment primary key,
    item_id  bigint       null,
    uuid     varchar(255) not null,
    reg_date datetime(6)  null,

    constraint fk_VoteInfo_Item foreign key (item_id) references ppoba.item (id)
);

