package com.cook.book.cook.repositories;

import com.cook.book.cook.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category,Long> {
}

