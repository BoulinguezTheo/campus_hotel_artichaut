package com.campus.campus_hotel_artichaut_backend.model.entity;

import com.campus.campus_hotel_artichaut_backend.model.RoomName;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RoomName name;

    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Media> images;

    @PositiveOrZero
    private Float price;

    @Nullable
    private Reference reference;
}
