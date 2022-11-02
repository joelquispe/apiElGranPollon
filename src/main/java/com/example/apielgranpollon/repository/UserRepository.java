package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.Cliente;
import com.example.apielgranpollon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value="SELECT  * FROM user WHERE username=?1 AND password=?2 ",nativeQuery = true)
    User findByUsernameAndPassword(String username, String password);
}
