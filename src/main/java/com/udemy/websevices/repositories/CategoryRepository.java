package com.udemy.websevices.repositories;

import com.udemy.websevices.entities.Category;
import com.udemy.websevices.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
