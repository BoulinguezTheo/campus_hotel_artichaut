package com.campus.campus_hotel_artichaut_backend.controller;

import com.campus.campus_hotel_artichaut_backend.dto.OptionDto;
import com.campus.campus_hotel_artichaut_backend.dto.ReservationDto;
import com.campus.campus_hotel_artichaut_backend.exception.NoOptionAvailableException;
import com.campus.campus_hotel_artichaut_backend.exception.NoRoomAvailableException;
import com.campus.campus_hotel_artichaut_backend.service.OptionService;
import com.campus.campus_hotel_artichaut_backend.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    private final OptionService optionService;

    @PostMapping
    public ReservationDto reserveRoom(@RequestBody @Valid ReservationDto reservationDto) {
        try {
            return this.reservationService.reserveRoom(reservationDto);
        } catch (NoRoomAvailableException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/options")
    public List<OptionDto> getAllOptions() {
        return this.optionService.getAllOptions();
    }
}
