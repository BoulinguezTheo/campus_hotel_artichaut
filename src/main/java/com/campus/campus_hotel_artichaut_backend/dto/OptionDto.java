package com.campus.campus_hotel_artichaut_backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OptionDto {
    private long id;

    private String description;

    private int price;

    private String name;

    private boolean isCancellable;
}
