package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Integer> {

}