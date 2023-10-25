package com.campus.campus_hotel_artichaut_backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date startDate;

    private Date endDate;

    private Reference reference;

    @PositiveOrZero
    private int price;

    @OneToOne(fetch = FetchType.LAZY)
    private Reservation reservation;
}
