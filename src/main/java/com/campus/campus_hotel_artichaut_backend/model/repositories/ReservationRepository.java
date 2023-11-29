package com.campus.campus_hotel_artichaut_backend.model.repositories;

import com.campus.campus_hotel_artichaut_backend.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByEndDateAfterAndStartDateBefore(Date startDate, Date endDate);

}

