package com.cook.book.cook.services.impl;

import com.cook.book.cook.dtos.CategoryDto;
import com.cook.book.cook.models.Category;
import com.cook.book.cook.repositories.CategoriesRepository;
import com.cook.book.cook.repositories.DishRepository;
import com.cook.book.cook.services.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final CategoriesRepository categoriesRepository;
    private final DishRepository dishRepository;
    @Override
    public List<CategoryDto> getCategoriesAndCountDishes() {
        List<CategoryDto> result=new ArrayList<>();
        List<Category> categories = categoriesRepository.findAll();
        for (Category category : categories) {
            CategoryDto dto=new CategoryDto();
            dto.setId(category.getId());
            dto.setName(category.getName());
            dto.setCountDishes(dishRepository.countByCategory(category));
            result.add(dto);
        }
        return result;
    }
}

