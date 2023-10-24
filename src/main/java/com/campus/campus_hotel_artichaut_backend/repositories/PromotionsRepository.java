package com.campus.campus_hotel_artichaut_backend.repositories;

import com.campus.campus_hotel_artichaut_backend.entities.Promotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionsRepository extends CrudRepository<Promotion, Long> {

}
