package com.udemy.websevices.repositories;

import com.udemy.websevices.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Savio","84 99991-8236","savio.dantas.5858@gmail.com","alltest");
        User u2 = new User(null,"Maria","85 99982-3489","maria.marya@gmail.com","maria123");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
