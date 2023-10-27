package com.campus.campus_hotel_artichaut_backend.controller;

import com.campus.campus_hotel_artichaut_backend.dto.RoomTypeDto;
import com.campus.campus_hotel_artichaut_backend.service.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/room-type")
@RequiredArgsConstructor
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @GetMapping
    public Set<RoomTypeDto> getAllRoomType() {
    return this.roomTypeService.getAllRoomType();
    }
}
