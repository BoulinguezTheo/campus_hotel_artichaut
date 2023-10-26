package com.campus.campus_hotel_artichaut_backend.mappers;

import com.campus.campus_hotel_artichaut_backend.dtos.RoomDto;
import com.campus.campus_hotel_artichaut_backend.entities.Room;
import com.campus.campus_hotel_artichaut_backend.entities.RoomType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = MediaMapper.class)
public interface RoomMapper {

    public RoomDto entityToDto(Room room);

    public Room dtoToEntity(RoomDto roomDto);

    default String map(RoomType roomType) {
        return roomType.getTitle();
    }

}
