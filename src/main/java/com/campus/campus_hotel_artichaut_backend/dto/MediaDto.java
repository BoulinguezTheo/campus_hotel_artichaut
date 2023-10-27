package com.campus.campus_hotel_artichaut_backend.dto;

import com.campus.campus_hotel_artichaut_backend.model.entity.MediaType;
import lombok.Data;

@Data
public class MediaDto {

    private Long id;

    private String link;

    private MediaType type;
}
