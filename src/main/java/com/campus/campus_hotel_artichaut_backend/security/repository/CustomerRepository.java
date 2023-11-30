package com.campus.campus_hotel_artichaut_backend.security.repository;

import com.campus.campus_hotel_artichaut_backend.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUserId(Long id);
}
