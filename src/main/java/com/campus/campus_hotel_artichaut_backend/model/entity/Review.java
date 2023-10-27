package com.campus.campus_hotel_artichaut_backend.model.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(1) @Max(5)
    private int notation;

    private String title;

    private Date date = new Date();

    @Nullable
    private String message;

    @OneToOne(fetch = FetchType.LAZY)
    private Reservation reservation;

}
