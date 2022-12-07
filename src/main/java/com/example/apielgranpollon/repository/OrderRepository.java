package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
    @Query(value="SELECT  * FROM orders WHERE cliente_id=?1 ",nativeQuery = true)
    Collection<Order> findByCustomer (Integer id);
}
