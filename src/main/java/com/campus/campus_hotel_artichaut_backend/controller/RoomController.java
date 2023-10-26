package com.campus.campus_hotel_artichaut_backend.controller;

import com.campus.campus_hotel_artichaut_backend.dtos.RoomDto;
import com.campus.campus_hotel_artichaut_backend.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public Collection<RoomDto> getAllRooms() {
        return this.roomService.getAllRooms();
    }

}
