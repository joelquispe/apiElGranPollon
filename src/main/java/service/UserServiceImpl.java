package service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepository;

import java.util.Collection;

public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
