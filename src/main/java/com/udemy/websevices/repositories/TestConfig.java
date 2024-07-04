package com.udemy.websevices.repositories;

import com.udemy.websevices.entities.Category;
import com.udemy.websevices.entities.Order;
import com.udemy.websevices.entities.Product;
import com.udemy.websevices.entities.User;
import com.udemy.websevices.entities.enums.OrderStatus;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Savio","84 99991-8236","savio.dantas.5858@gmail.com","alltest");
        User u2 = new User(null,"Maria","85 99982-3489","maria.marya@gmail.com","maria123");
        Order o1 = new Order(null, Instant.parse("2024-06-28T09:52:07Z"), OrderStatus.WAITING_PAYMENT,u1);
        Order o2 = new Order(null, Instant.parse("2024-06-28T09:53:27Z"), OrderStatus.PAID, u2);
        Order o3 = new Order(null, Instant.parse("2024-06-28T09:52:50Z"), OrderStatus.CANCELED, u1);
        Category c1 = new Category(null, "Books");
        Category c2 = new Category(null,"Technologies");
        Category c3 = new Category(null, "Clothes");
        Product p1 = new Product(null,"RTX 2080","video board",800.0,"0hfaldf.img");
        Product p2 = new Product(null,"Sapiens","history of humanity",50.0,"af9qw.img");
        Product p3 = new Product(null,"dress","lilac glitter dress",100.0,"noaraodhjfa.png");
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3));
    }
}
