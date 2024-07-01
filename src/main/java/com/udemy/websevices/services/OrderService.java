package com.udemy.websevices.services;

import com.udemy.websevices.entities.Order;
import com.udemy.websevices.entities.User;
import com.udemy.websevices.repositories.OrderRepository;
import com.udemy.websevices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
