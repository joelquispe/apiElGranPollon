package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.MotorizedStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorizedStatusRepository extends JpaRepository<MotorizedStatus,Integer> {

}
