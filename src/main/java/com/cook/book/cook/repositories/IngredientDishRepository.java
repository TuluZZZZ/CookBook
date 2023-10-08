package com.cook.book.cook.repositories;

import com.cook.book.cook.models.Dish;
import com.cook.book.cook.models.IngredientDish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientDishRepository extends JpaRepository<IngredientDish,Long> {
    List<IngredientDish> findIngredientDishByDish(Dish dish);
}
