package com.campus.campus_hotel_artichaut_backend.mapper;

import com.campus.campus_hotel_artichaut_backend.dto.RoomDto;
import com.campus.campus_hotel_artichaut_backend.model.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = RoomTypeMapper.class)
public interface RoomMapper {

    public RoomDto entityToDto(Room room);

    public Room dtoToEntity(RoomDto roomDto);

}
