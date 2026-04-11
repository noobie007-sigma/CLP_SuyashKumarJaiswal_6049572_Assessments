package com.example.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user_service.entity.User;
import com.example.user_service.exception.UserNotFoundException;
import com.example.user_service.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User getUser(Long id) {
        return repo.findById(id)
        		.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    public User save(User user) {
        return repo.save(user);
    }
}