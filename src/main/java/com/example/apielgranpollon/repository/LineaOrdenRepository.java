package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.LineaOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaOrdenRepository extends JpaRepository<LineaOrden,Integer>{
}
