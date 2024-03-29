package ru.practicum.shareit.item.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.practicum.shareit.booking.BookingMapper;
import ru.practicum.shareit.item.dto.ItemForRequestResponse;
import ru.practicum.shareit.item.dto.ItemFromRequest;
import ru.practicum.shareit.item.dto.ItemResponse;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.UserMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {UserMapper.class, BookingMapper.class, CommentMapper.class})
public interface ItemMapper {


    Item toItem(ItemFromRequest itemFromRequest);

    ItemResponse toItemResponse(Item item);

    ItemForRequestResponse toItemForRequestResponse(Item item);
}
