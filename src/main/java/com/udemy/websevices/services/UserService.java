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
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void insert(User user) {
        repository.save(user);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User user) {
        User entity = repository.getReferenceById(id);
        updateData(entity,user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
