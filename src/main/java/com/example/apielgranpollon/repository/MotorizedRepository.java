package com.example.apielgranpollon.repository;


import com.example.apielgranpollon.entity.Motorized;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorizedRepository extends JpaRepository<Motorized,Integer> {

}
