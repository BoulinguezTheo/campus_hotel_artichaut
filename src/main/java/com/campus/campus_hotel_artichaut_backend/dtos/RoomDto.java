package com.campus.campus_hotel_artichaut_backend.dtos;

import com.campus.campus_hotel_artichaut_backend.entities.Reference;
import com.campus.campus_hotel_artichaut_backend.entities.RoomType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDto {

    private Long id;

    private Integer number;

    private String type;

    private Float price;

    private String description;

    private Reference reference;

    private Collection<MediaDto> media;
    
    private Collection<Date> availabilities;
}
