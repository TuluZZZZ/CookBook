package com.cook.book.cook.services;

import com.cook.book.cook.dtos.CategoryDto;

import java.util.List;

public interface DishService {
    List<CategoryDto> getCategoriesAndCountDishes();
}

