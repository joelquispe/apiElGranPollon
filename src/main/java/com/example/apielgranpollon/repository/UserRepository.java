package com.example.apielgranpollon.repository;

import com.example.apielgranpollon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
