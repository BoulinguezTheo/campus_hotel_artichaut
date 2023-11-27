package com.campus.campus_hotel_artichaut_backend.security.repository;

import com.campus.campus_hotel_artichaut_backend.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
