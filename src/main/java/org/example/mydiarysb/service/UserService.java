package org.example.mydiarysb.service;

import org.example.mydiarysb.entity.User;

public interface UserService {
    public User save(User user);
    public void delete(User user);
    public User findById(long id);
    public User findbyUsername(String username);
}
