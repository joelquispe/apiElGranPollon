package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.User;
import java.util.Collection;

public interface UserService {
    public abstract void insert(User user);
    public abstract void update(User user);
    public abstract void delete(Integer userId);
    public abstract User findById(Integer userId);
    public abstract Collection<User> findAll();

    public abstract  User findByUsernameAndPassword(String username,String password);
}
