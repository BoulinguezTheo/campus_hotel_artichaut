package com.campus.campus_hotel_artichaut_backend.model.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int number;

    @ManyToOne
    private RoomType type;
}
