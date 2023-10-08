package com.cook.book.cook.services.impl;

import com.cook.book.cook.convertors.IngredientToIngredientDtoConvertor;
import com.cook.book.cook.dtos.IngredientDto;
import com.cook.book.cook.models.Dish;
import com.cook.book.cook.models.Ingredient;
import com.cook.book.cook.models.IngredientDish;
import com.cook.book.cook.models.Measurement;
import com.cook.book.cook.repositories.DishRepository;
import com.cook.book.cook.repositories.IngredientDishRepository;
import com.cook.book.cook.repositories.IngredientRepository;
import com.cook.book.cook.repositories.MeasurementRepository;
import com.cook.book.cook.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl  implements IngredientService {
    private final MeasurementRepository measurementRepository;
    private final IngredientRepository ingredientRepository;
    private final DishRepository dishRepository;
    private final IngredientDishRepository ingredientDishRepository;
    private final IngredientToIngredientDtoConvertor ingredientToIngredientDtoConvertor;
    @Override
    public void createIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient=new Ingredient();
        ingredient.setIngredientName(ingredientDto.getIngredientName());
        Measurement measurement = measurementRepository.findById(ingredientDto.getMeasurementId()).orElse(null);
        ingredient.setMeasurement(measurement);
        ingredientRepository.save(ingredient);
    }

    @Override
    public List<IngredientDto> getIngredientsByDish(Long dishId) {
        List<IngredientDto> result=new ArrayList<>();
        Dish dish = dishRepository.findById(dishId).orElse(null);
        List<IngredientDish> ingredientDishByDish = ingredientDishRepository.findIngredientDishByDish(dish);
        for (IngredientDish el : ingredientDishByDish) {
            IngredientDto dto = ingredientToIngredientDtoConvertor.convert(el.getIngredient());
            dto.setQuantity(el.getQuantity());
            result.add(dto);
        }
        return result;
    }

    @Override
    public List<IngredientDto> getAll() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return   ingredients.stream().map(ingredient -> ingredientToIngredientDtoConvertor.convert(ingredient)).toList();
    }

    @Override
    public void addIngredient(IngredientDto ingredientDto, Long dishId) {
        Ingredient ingredient = ingredientRepository.findById(ingredientDto.getId()).orElse(null);
        Dish dish = dishRepository.findById(dishId).orElse(null);
        IngredientDish ingredientDish=new IngredientDish();
        ingredientDish.setDish(dish);
        ingredientDish.setIngredient(ingredient);
        ingredientDish.setQuantity(ingredientDto.getQuantity());
        ingredientDishRepository.save(ingredientDish);
    }
}
