package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
        @Query(value="SELECT  * FROM cliente WHERE email=?1 AND password=?2 ",nativeQuery = true)
        Cliente findByEmailAndPassword(String email,String password);
}
