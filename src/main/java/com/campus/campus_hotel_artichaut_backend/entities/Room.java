package com.campus.campus_hotel_artichaut_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
public class Room {

    @Id
    private long id;

    private int number;

    @NotNull
    private RoomType type;

    @PositiveOrZero
    private Float price;

    @NotBlank
    private String description;

    @NotNull
    private Reference reference;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Media> media;
}
