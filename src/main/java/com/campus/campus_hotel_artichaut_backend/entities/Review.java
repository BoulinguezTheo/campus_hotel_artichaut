package com.campus.campus_hotel_artichaut_backend.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Review {

    @Id
    private long id;

    @Min(1) @Max(5)
    private int notation;

    private String title;

    private Date date = new Date();

    @Nullable
    private String message;

    @OneToOne
    private Reservation reservation;

}
