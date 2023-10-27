package com.campus.campus_hotel_artichaut_backend.repository;

import com.campus.campus_hotel_artichaut_backend.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
