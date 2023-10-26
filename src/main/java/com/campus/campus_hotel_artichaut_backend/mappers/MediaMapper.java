package com.campus.campus_hotel_artichaut_backend.mappers;

import com.campus.campus_hotel_artichaut_backend.dtos.MediaDto;
import com.campus.campus_hotel_artichaut_backend.entities.Media;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MediaMapper {

    @Mapping(target = "news" , ignore = true)
    public Media dtoToEntity(MediaDto mediaDto);

    public MediaDto entityToDto(Media media);

}
