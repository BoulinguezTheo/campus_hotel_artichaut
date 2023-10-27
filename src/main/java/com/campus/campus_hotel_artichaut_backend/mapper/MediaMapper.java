package com.campus.campus_hotel_artichaut_backend.mapper;

import com.campus.campus_hotel_artichaut_backend.dto.MediaDto;
import com.campus.campus_hotel_artichaut_backend.model.entity.Media;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MediaMapper {

    @Mapping(target = "news" , ignore = true)
    public Media dtoToEntity(MediaDto mediaDto);

    public MediaDto entityToDto(Media media);

}
