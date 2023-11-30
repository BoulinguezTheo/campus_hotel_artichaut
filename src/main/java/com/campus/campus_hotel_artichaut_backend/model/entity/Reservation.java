package com.campus.campus_hotel_artichaut_backend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
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

    @Min(1)
    @Max(3)
    private int numberOfPerson;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Option> options;
}
