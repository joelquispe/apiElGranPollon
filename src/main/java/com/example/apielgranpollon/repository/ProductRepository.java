package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
}