package com.campus.campus_hotel_artichaut_backend.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String link;

    @NotNull
    private MediaType type;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<News> news;
}
