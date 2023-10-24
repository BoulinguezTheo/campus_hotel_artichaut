package com.campus.campus_hotel_artichaut_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Entity
public class Option {

    @Id
    private long id;

    private String description;

    @PositiveOrZero
    private int price;

    private String name;

    @NotNull
    private Duration duration;

    private boolean isCancellable;

    private Reference reference;
}
