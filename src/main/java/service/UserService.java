package service;

import entity.User;

import java.util.Collection;

public interface UserService {
    public abstract void insert(User producto);
    public abstract void update(User producto);
    public abstract void delete(Integer productoId);
    public abstract User findById(Integer productoId);
    public abstract Collection<User> findAll();
}
