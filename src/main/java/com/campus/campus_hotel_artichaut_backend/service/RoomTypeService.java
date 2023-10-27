package com.campus.campus_hotel_artichaut_backend.service;

import com.campus.campus_hotel_artichaut_backend.dto.RoomTypeDto;
import com.campus.campus_hotel_artichaut_backend.mapper.RoomTypeMapper;
import com.campus.campus_hotel_artichaut_backend.model.RoomName;
import com.campus.campus_hotel_artichaut_backend.model.entity.RoomType;
import com.campus.campus_hotel_artichaut_backend.model.repositories.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    private final RoomTypeMapper roomTypeMapper;

    public Set<RoomTypeDto> getAllRoomType() {
        return roomTypeRepository.findAll().stream().map(roomType -> mapRoomTypeEntityToDto(roomType)).collect(Collectors.toSet());
    }

    private RoomTypeDto mapRoomTypeEntityToDto(RoomType roomType) {
        RoomTypeDto roomTypeDto = roomTypeMapper.entityToDto(roomType);
        roomTypeDto.setArrivalAvailabilities(determineArrivalAvailabilities(roomType.getName()));
        return roomTypeDto;
    }

    // TODO : IMPLEMENT LOGIC
    private Collection<Date> determineArrivalAvailabilities(RoomName name) {
        return List.of();
    }
}
