package com.udemy.websevices.repositories;

import com.udemy.websevices.entities.Order;
import com.udemy.websevices.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Savio","84 99991-8236","savio.dantas.5858@gmail.com","alltest");
        User u2 = new User(null,"Maria","85 99982-3489","maria.marya@gmail.com","maria123");
        Order o1 = new Order(null, Instant.parse("2024-06-28T09:52:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2024-06-28T09:53:27Z"), u2);
        Order o3 = new Order(null, Instant.parse("2024-06-28T09:52:50Z"), u1);
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
