package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Plates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatesRepository extends JpaRepository<Plates,Integer>{
}