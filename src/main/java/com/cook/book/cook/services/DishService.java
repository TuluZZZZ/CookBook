package com.cook.book.cook.services;

import com.cook.book.cook.dtos.CategoryDto;
import com.cook.book.cook.dtos.DishDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DishService {
    List<CategoryDto> getCategoriesAndCountDishes();

    DishDto saveDish(DishDto dish, MultipartFile file) throws IOException;

    List<DishDto> getAllDishByCategory(Long categoryId);

    DishDto getDishById(Long dishId);
}

