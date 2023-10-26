package com.campus.campus_hotel_artichaut_backend.dtos;

import com.campus.campus_hotel_artichaut_backend.entities.MediaType;
import lombok.Data;

@Data
public class MediaDto {

    private Long id;

    private String link;

    private MediaType type;
}
