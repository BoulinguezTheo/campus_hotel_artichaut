package com.campus.campus_hotel_artichaut_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ReservationDto {

    private long id;

    private long customerId;

    private Date startDate;

    private Date endDate;

    private String roomName;

    private int numberOfPerson;
}
