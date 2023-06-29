package com.project.ppoba.application.item;

import com.project.ppoba.application.room.Room;
import com.project.ppoba.application.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final RoomService roomService;

    private final ItemRepository itemRepository;
    private final VoteRepository voteRepository;

    public long create(long roomId, String name, String resourceUri) {
        Room room = roomService.findById(roomId);
        // if(room.getStatus() != Status.IN_PROGRESS) throw new Exception();

        Item item = Item.of(room, name, resourceUri);

        return itemRepository.save(item).getId();
    }

    public long vote(long itemId, String uuid) {
        Item item = findById(itemId);
        List<VoteInfo> vote = voteRepository.findAllByItemAndUuid(item, uuid);
        // if(vote != null) throw nre Exception()

        VoteInfo voteInfo = VoteInfo.of(uuid, item);
        return voteRepository.save(voteInfo).getId();
    }

    private Item findById(long itemId) {
        return itemRepository.findById(itemId).orElseThrow();
    }
}
