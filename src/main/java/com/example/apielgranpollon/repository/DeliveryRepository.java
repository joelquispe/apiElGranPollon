package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Integer>{
}