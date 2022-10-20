package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.PlatesDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatesDetailsRepository extends JpaRepository<PlatesDetails,Integer>{
}
