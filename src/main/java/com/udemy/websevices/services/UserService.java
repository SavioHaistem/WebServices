package com.udemy.websevices.services;

import com.udemy.websevices.entities.User;
import com.udemy.websevices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User findById(Long id) {
        Optional<User> optionalUser = repository.findById(id);
        return optionalUser.get();
    }
    public List<User> findAll() {
        return repository.findAll();
    }
}
