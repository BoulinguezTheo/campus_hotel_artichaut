package com.campus.campus_hotel_artichaut_backend.mapper;

import com.campus.campus_hotel_artichaut_backend.dto.OptionDto;
import com.campus.campus_hotel_artichaut_backend.model.entity.Option;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = MediaMapper.class)
public interface OptionMapper {
    OptionDto entityToDto(Option option);

    Option dtoToEntity(OptionDto optionDto);
}
