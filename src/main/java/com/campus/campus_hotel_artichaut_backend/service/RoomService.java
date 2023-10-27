package com.campus.campus_hotel_artichaut_backend.service;

import com.campus.campus_hotel_artichaut_backend.dto.RoomDto;
import com.campus.campus_hotel_artichaut_backend.mapper.RoomMapper;
import com.campus.campus_hotel_artichaut_backend.model.entity.Room;
import com.campus.campus_hotel_artichaut_backend.model.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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
    public Optional<RoomDto> getRoomById(Long id) {
        return this.roomRepository.findById(id)
                .map(this.roomMapper::entityToDto);
    }
}
