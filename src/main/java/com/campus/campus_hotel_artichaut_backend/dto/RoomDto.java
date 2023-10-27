package com.campus.campus_hotel_artichaut_backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDto {

    private Long id;

    private Integer number;

    private RoomTypeDto type;
}
