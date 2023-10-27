package com.campus.campus_hotel_artichaut_backend.model.repositories;

import com.campus.campus_hotel_artichaut_backend.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
