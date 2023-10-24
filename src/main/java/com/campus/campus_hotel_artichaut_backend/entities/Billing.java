package com.campus.campus_hotel_artichaut_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Billing {
    @Id
    private long id;

    private Date startDate;

    private Date endDate;

    private Reference reference;

    @PositiveOrZero
    private int price;

    @OneToOne
    private Reservation reservation;
}
