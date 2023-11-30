package com.campus.campus_hotel_artichaut_backend.controller;

import com.campus.campus_hotel_artichaut_backend.dto.ReservationDto;
import com.campus.campus_hotel_artichaut_backend.exception.NoRoomAvailableException;
import com.campus.campus_hotel_artichaut_backend.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ReservationDto reserveRoom(@RequestBody @Valid ReservationDto reservationDto) {
        try {
            return this.reservationService.reserveRoom(reservationDto);
        } catch (NoRoomAvailableException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
