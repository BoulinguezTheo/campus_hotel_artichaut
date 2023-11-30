package com.campus.campus_hotel_artichaut_backend.exception;

import com.campus.campus_hotel_artichaut_backend.model.entity.RoomType;

import java.util.Date;

public class NoRoomAvailableException extends Exception {
    public NoRoomAvailableException(String roomName, Date startDate, Date endDate) {
        super(String.format("No room of type %s available between dates %s and %s", roomName, startDate.toString(), endDate.toString()));
    }
}
