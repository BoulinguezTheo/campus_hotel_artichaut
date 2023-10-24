package com.campus.campus_hotel_artichaut_backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
@Entity
public class Reservation {

    @Id
    private long id;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Customer customer;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private Date reservationDate = new Date();

    private boolean isCancelled;

    @PositiveOrZero
    private float price;

    private boolean isPaid;

    private String qrCode;

    private boolean isMailSent;

    @PositiveOrZero
    private float roomPrice;

    @Min(1) @Max(3)
    private int numberOfPerson;

    @ManyToMany
    private Collection<Option> options;
}
