package org.example.mydiarysb.service;

import org.example.mydiarysb.entity.User;
import org.example.mydiarysb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
   private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
         userRepository.delete(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public User findbyUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
