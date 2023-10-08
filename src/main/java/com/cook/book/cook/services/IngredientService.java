package com.cook.book.cook.services;

import com.cook.book.cook.dtos.IngredientDto;

import java.util.List;

public interface IngredientService {
    void createIngredient(IngredientDto ingredientDto);
    List<IngredientDto> getIngredientsByDish(Long dishId);

    List<IngredientDto> getAll();

    void addIngredient(IngredientDto ingredientDto,Long dishId);
}
