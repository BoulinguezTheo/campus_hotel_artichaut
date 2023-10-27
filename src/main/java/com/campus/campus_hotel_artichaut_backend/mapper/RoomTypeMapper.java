package com.campus.campus_hotel_artichaut_backend.mapper;

import com.campus.campus_hotel_artichaut_backend.dto.RoomTypeDto;
import com.campus.campus_hotel_artichaut_backend.model.entity.RoomType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = MediaMapper.class)
public interface RoomTypeMapper {
    public RoomTypeDto entityToDto(RoomType roomType);

    public RoomType dtoToEntity(RoomTypeDto roomTypeDto);
}
