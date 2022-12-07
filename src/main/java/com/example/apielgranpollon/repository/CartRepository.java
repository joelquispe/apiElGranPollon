package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
    @Query(value="SELECT  * FROM cart WHERE cliente_id=?1 ",nativeQuery = true)
    Collection<Cart> findByCustomer (Integer id);
}
