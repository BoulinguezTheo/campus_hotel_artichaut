package com.campus.campus_hotel_artichaut_backend.model.repositories;

import com.campus.campus_hotel_artichaut_backend.model.RoomName;
import com.campus.campus_hotel_artichaut_backend.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByType_Name(RoomName name);
}
