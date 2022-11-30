package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.MethodPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MethodPayRepository extends JpaRepository<MethodPay,Integer>{
}
