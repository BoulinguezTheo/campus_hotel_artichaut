package com.campus.campus_hotel_artichaut_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
public class Media {
    @Id
    private Long id;

    @NotBlank
    private String link;

    @NotNull
    private MediaType type;

    @ManyToMany
    private Collection<News> news;
}
