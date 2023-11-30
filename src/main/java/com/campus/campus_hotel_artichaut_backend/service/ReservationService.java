package com.campus.campus_hotel_artichaut_backend.service;

import com.campus.campus_hotel_artichaut_backend.dto.ReservationDto;
import com.campus.campus_hotel_artichaut_backend.exception.NoRoomAvailableException;
import com.campus.campus_hotel_artichaut_backend.model.RoomName;
import com.campus.campus_hotel_artichaut_backend.model.entity.Reservation;
import com.campus.campus_hotel_artichaut_backend.model.entity.Room;
import com.campus.campus_hotel_artichaut_backend.model.repositories.CustomerRepository;
import com.campus.campus_hotel_artichaut_backend.model.repositories.ReservationRepository;
import com.campus.campus_hotel_artichaut_backend.model.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;

    public ReservationDto reserveRoom(ReservationDto reservationDto) {
        Optional<Room> availableRoom = this.findAvailableRoom(
                RoomName.valueOf(reservationDto.getRoomName()),
                reservationDto.getStartDate(),
                reservationDto.getEndDate()
        );
        if (availableRoom.isEmpty()) {
            throw new NoRoomAvailableException(reservationDto.getRoomName(), reservationDto.getStartDate(), reservationDto.getEndDate());
        }
        Reservation reservation = Reservation.builder()
                .room(availableRoom.get())
                .reservationDate(new Date())
                .isPaid(false)
                .isCancelled(false)
                .roomPrice(availableRoom.get().getType().getPrice())
                .isMailSent(false)
                .customer(this.customerRepository.findById(reservationDto.getCustomerId()).orElseThrow())
                .build();
        Reservation reservationMade = this.reservationRepository.save(reservation);
        return new ReservationDto(
                reservationMade.getId(),
                reservationDto.getCustomerId(),
                reservationMade.getStartDate(),
                reservationMade.getEndDate(),
                reservationMade.getRoom().getType().getName().getTitle(),
                reservationMade.getNumberOfPerson()
        );
    }

    private Optional<Room> findAvailableRoom(RoomName roomName, Date startDate, Date endDate) {
        List<Room> rooms = this.roomRepository.findByType_Name(roomName);
        Set<Long> roomIds = this.reservationRepository.findByEndDateAfterAndStartDateBefore(startDate, endDate).stream()
                .map(Reservation::getId)
                .collect(Collectors.toSet());
        return rooms.stream()
                .filter(room -> !roomIds.contains(room.getId()))
                .findFirst();
    }
}
