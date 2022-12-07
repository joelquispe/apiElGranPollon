package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Address;
import com.example.apielgranpollon.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>{
    @Query(value="SELECT  * FROM address WHERE cliente_id=?1 ",nativeQuery = true)
    Collection<Address> findByCustomer (Integer id);
}