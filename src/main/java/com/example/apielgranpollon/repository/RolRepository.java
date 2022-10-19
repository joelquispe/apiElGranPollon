package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer>{
}
