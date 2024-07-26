package com.udemy.websevices.services;

import com.udemy.websevices.entities.User;
import com.udemy.websevices.repositories.UserRepository;
import com.udemy.websevices.services.exceptions.DatabaseException;
import com.udemy.websevices.services.exceptions.ResourceNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void insert(User user) {
        repository.save(user);
    }

    public void deleteById(Long id) {
        try {
            if (findById(id) != null) {
                repository.deleteById(id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
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
