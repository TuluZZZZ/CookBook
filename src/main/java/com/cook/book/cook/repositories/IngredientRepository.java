package com.cook.book.cook.repositories;

import com.cook.book.cook.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

}
