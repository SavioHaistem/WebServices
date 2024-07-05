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
        Category c2 = new Category(null, "Books");
        Category c1 = new Category(null,"Electronics");
        Category c3 = new Category(null, "Computers");
        Product p1 = new Product(null,"The Lord of the Rings","Lorem ipsum dolor sit amet",90.5,"lorg.png");
        Product p2 = new Product(null,"SmartTV","Nulla eu ipsum lorem purus",2190.0,"smarttv.png");
        Product p3 = new Product(null,"MacBook Pro","lorem ipsum dolor eu amat",1250.0,"macbookpro.png");
        Product p4 = new Product(null,"PC Gamer","Donec aliquer odio ac rhocus cursus",1200.0,"pcgamer.png");
        Product p5 = new Product(null,"Rails for Dummies","Cras fringilla convallis sem vel faucibus",100.99,"railsfordummies.png");
        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c1);
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3));
    }
}
