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
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public ReservationDto reserveRoom(ReservationDto reservationDto) throws NoRoomAvailableException {
        Optional<Room> availableRoom = this.findAvailableRoom(
                RoomName.valueOf(reservationDto.getRoomName()),
                reservationDto.getStartDate(),
                reservationDto.getEndDate()
        );
        if (availableRoom.isEmpty()) {
            throw new NoRoomAvailableException(reservationDto.getRoomName(), reservationDto.getStartDate(), reservationDto.getEndDate());
        }
        Reservation reservationToSave = buildReservationToSave(reservationDto, availableRoom);
        Reservation reservationMade = this.reservationRepository.save(reservationToSave);
        return this.mapReservationEntityToReservationDto(reservationMade);
    }

    private Reservation buildReservationToSave(ReservationDto reservationDto, Optional<Room> availableRoom) {
        return Reservation.builder()
                .room(availableRoom.get())
                .reservationDate(new Date())
                .isPaid(false)
                .isCancelled(false)
                .roomPrice(availableRoom.get().getType().getPrice())
                .isMailSent(false)
                .startDate(reservationDto.getStartDate())
                .endDate(reservationDto.getEndDate())
                .customer(this.customerRepository.findById(reservationDto.getCustomerId()).orElseThrow())
                .room(availableRoom.get())
                .build();
    }

    private Optional<Room> findAvailableRoom(RoomName roomName, Date startDate, Date endDate) {
        List<Room> rooms = this.roomRepository.findByType_Name(roomName);
        Set<Long> roomIds = this.reservationRepository.findByEndDateAfterAndStartDateBefore(startDate, endDate).stream()
                .map(reservation -> reservation.getRoom().getId())
                .collect(Collectors.toSet());
        return rooms.stream()
                .filter(room -> !roomIds.contains(room.getId()))
                .findFirst();
    }

    private ReservationDto mapReservationEntityToReservationDto(Reservation reservation) {
        return new ReservationDto(
                reservation.getId(),
                reservation.getCustomer().getId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getRoom().getType().getName().getTitle(),
                reservation.getNumberOfPerson()
        );
    }
}
