package com.campus.campus_hotel_artichaut_backend.model.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
public class RoomType {
    @Id
    private Long id;

    private String category;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Media> image;

    @PositiveOrZero
    private Float price;

    @Nullable
    private Reference reference;
}
