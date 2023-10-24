package com.campus.campus_hotel_artichaut_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Entity
@Data
public class Promotion {
    @Id
    private Long id;

    @NotBlank
    private String description;

    @PositiveOrZero
    private float discount;

    @PositiveOrZero
    private int minNumberOfNights;
}
