package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Qualifier("product")
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
    @Query("SELECT p FROM product p JOIN p.category c "+ "WHERE c.name LIKE %?1%")
    Collection<Product> findProductByCategory (String category);
}