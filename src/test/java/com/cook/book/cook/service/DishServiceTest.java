package com.cook.book.cook.service;

import com.cook.book.cook.convertors.DishDtoToDishConvertor;
import com.cook.book.cook.convertors.DishToDishDtoConvertor;
import com.cook.book.cook.dtos.CategoryDto;
import com.cook.book.cook.dtos.DishDto;
import com.cook.book.cook.models.Category;
import com.cook.book.cook.models.Dish;
import com.cook.book.cook.repositories.CategoriesRepository;
import com.cook.book.cook.repositories.DishRepository;
import com.cook.book.cook.services.impl.DishServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class DishServiceTest {
    @Mock
    private CategoriesRepository categoriesRepository;
    @Mock
    private DishRepository dishRepository;
    @Mock
    private DishDtoToDishConvertor dishDtoToDishConvertor;
    @Mock
    private DishToDishDtoConvertor dishToDishDtoConvertor;

    @Test
    public void getCategoriesAndCountDishes() {
        DishServiceImpl dishService = new DishServiceImpl(categoriesRepository, dishRepository, dishDtoToDishConvertor, dishToDishDtoConvertor);
        List<Category> categories = List.of(new Category(1l, "fresh", List.of(new Dish(1l, "first", null, null, null, null, null, null))),
                new Category(1l, "fresh", List.of(new Dish(2l, "second", null, null, null, null, null, null))));
        when(categoriesRepository.findAll()).thenReturn(categories);
        when(dishRepository.countByCategory(any())).thenReturn(1);
        List<CategoryDto> categoriesAndCountDishes = dishService.getCategoriesAndCountDishes();
        List<CategoryDto> expected = List.of(new CategoryDto(1l, "fresh", 1), new CategoryDto(1L, "fresh", 1));
        Assert.assertEquals(expected, categoriesAndCountDishes);
    }

    @Test
    public void getAllDishByCategory() {
        DishServiceImpl dishService = new DishServiceImpl(categoriesRepository, dishRepository, dishDtoToDishConvertor, dishToDishDtoConvertor);
        Optional<Category> category = Optional.of(new Category(1l, "fresh", List.of(new Dish(1l, "first", null, null, null, null, null, null))));
        when(categoriesRepository.findById(any())).thenReturn(category);
        when(dishRepository.findAllByCategory(any())).thenReturn(List.of(new Dish(1l, "first", null, null, null, null, null, null)));
        List<DishDto> expected=new ArrayList<>();
        List<DishDto> allDishByCategory = dishService.getAllDishByCategory(1l);
        Assert.assertEquals(1,allDishByCategory.size());
    }
}
