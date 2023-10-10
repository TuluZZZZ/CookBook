package com.cook.book.cook.service;

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
import com.cook.book.cook.services.impl.IngredientServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class IngredientServiceTest {

    @Mock
    private MeasurementRepository measurementRepository;
    @Mock
    private IngredientRepository ingredientRepository;
    @Mock
    private DishRepository dishRepository;
    @Mock
    private IngredientDishRepository ingredientDishRepository;
    @Mock
    private IngredientToIngredientDtoConvertor ingredientToIngredientDtoConvertor;

    @Test
    public void getAllIngredient() {
        when(ingredientRepository.findAll()).thenReturn(List.of(
                        new Ingredient(1l,"ing1",new Measurement(1l,"gr",2.0,null),null),
                        new Ingredient(2l,"ing2",new Measurement(1l,"gr",12.0,null),null),
                        new Ingredient(3l,"ing2",new Measurement(1l,"gr",20.0,null),null)
                )
        );
        IngredientServiceImpl ingredientService = new IngredientServiceImpl(measurementRepository, ingredientRepository, dishRepository, ingredientDishRepository, ingredientToIngredientDtoConvertor);
        List<IngredientDto> all = ingredientService.getAll();
        Assert.assertEquals(3,all.size());
    }

    @Test
    public void getIngredientsByDish(){
        Optional<Dish>  dish= Optional.of(new Dish(1l, "newDish", "newDescr", 20, null, null, null, null));
        when(dishRepository.findById(anyLong())).thenReturn(dish);
        List<IngredientDish> ingredientDishes=new ArrayList<>();
        ingredientDishes.add(new IngredientDish(1l,2,dish.get(),new Ingredient(1l,"ing1",null,null)));
        when(ingredientDishRepository.findIngredientDishByDish(dish.get())).thenReturn(ingredientDishes);
        when(ingredientToIngredientDtoConvertor.convert(any())).thenReturn(new IngredientDto(1l,"ing1",1l,"gr",2));
        IngredientServiceImpl ingredientService = new IngredientServiceImpl(measurementRepository, ingredientRepository, dishRepository, ingredientDishRepository, ingredientToIngredientDtoConvertor);
        List<IngredientDto> ingredientsByDish = ingredientService.getIngredientsByDish(1L);
        Assert.assertEquals(1,ingredientsByDish.size());
        Assert.assertEquals("ing1",ingredientsByDish.get(0).getIngredientName());
    }
}


