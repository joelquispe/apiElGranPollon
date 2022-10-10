package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business,Integer>{
}
