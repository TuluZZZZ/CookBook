package com.cook.book.cook.repositories;

import com.cook.book.cook.models.Category;
import com.cook.book.cook.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish,Long> {
    Integer countByCategory(Category category);
}

