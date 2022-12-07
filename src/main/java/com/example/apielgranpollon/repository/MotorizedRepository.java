package com.example.apielgranpollon.repository;


import com.example.apielgranpollon.entity.Cliente;
import com.example.apielgranpollon.entity.Motorized;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorizedRepository extends JpaRepository<Motorized,Integer> {
    @Query(value="SELECT  * FROM motorized WHERE email=?1 AND password=?2 ",nativeQuery = true)
    Motorized findByEmailAndPassword(String email, String password);
}
