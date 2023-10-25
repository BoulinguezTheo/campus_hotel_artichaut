package com.campus.campus_hotel_artichaut_backend.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int number;

    @NotNull
    private RoomType type;

    @PositiveOrZero
    private Float price;

    @NotBlank
    private String description;

    @Nullable
    private Reference reference;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Media> media;
}
