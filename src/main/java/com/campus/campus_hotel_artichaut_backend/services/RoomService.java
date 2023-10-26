package com.campus.campus_hotel_artichaut_backend.services;

import com.campus.campus_hotel_artichaut_backend.dtos.RoomDto;
import com.campus.campus_hotel_artichaut_backend.entities.Room;
import com.campus.campus_hotel_artichaut_backend.mappers.RoomMapper;
import com.campus.campus_hotel_artichaut_backend.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public Collection<RoomDto> getAllRooms() {
        Collection<Room> rooms = this.roomRepository.findAll();
        return rooms
                .stream()
                .map(roomMapper::entityToDto)
                .toList();
    }
}
