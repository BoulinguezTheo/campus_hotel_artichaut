package com.campus.campus_hotel_artichaut_backend.dto;

import com.campus.campus_hotel_artichaut_backend.model.RoomName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.Collection;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomTypeDto {

    private RoomName name;

    private String description;

    private Collection<MediaDto> images;

    private Float price;

    private Collection<Date> arrivalAvailabilities;
}
