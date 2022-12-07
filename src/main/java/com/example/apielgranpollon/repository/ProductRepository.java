package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
    @Query(value="select p.id,p.name,p.price,p.description,p.image,p.status,p.stock from product as p INNER JOIN category as c ON c.id = p.categoria_id where c.name=?1",nativeQuery = true)
    Collection<Product> findProductByCategory (String category);
}