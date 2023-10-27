package com.campus.campus_hotel_artichaut_backend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RoomCategory {
    LUXURY("Chambre de Luxe"),
    COSY("Chambre Cosy"),
    SUITE("Suite de Luxe")
    ;

    private final String title;
}
