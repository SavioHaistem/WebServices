package com.udemy.websevices.services;

import com.udemy.websevices.entities.User;
import com.udemy.websevices.repositories.UserRepository;
import com.udemy.websevices.services.exceptions.DatabaseException;
import com.udemy.websevices.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
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
            throw new DatabaseException("Integrity violation error for user with id: " + id + ", we can`t remove this");
        }
    }

    public User update(Long id, User user) {
        User entity = repository.getReferenceById(id);
        try {
            updateData(entity,user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
        return repository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
