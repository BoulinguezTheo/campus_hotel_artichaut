package com.campus.campus_hotel_artichaut_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class News {
    @Id
    private Long id;

    @NotBlank
    private String description;
}
