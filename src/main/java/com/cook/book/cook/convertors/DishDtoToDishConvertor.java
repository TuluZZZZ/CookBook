package com.cook.book.cook.convertors;

import com.cook.book.cook.dtos.DishDto;
import com.cook.book.cook.models.Category;
import com.cook.book.cook.models.Dish;
import com.cook.book.cook.repositories.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DishDtoToDishConvertor extends Convertor<Dish, DishDto>{
    private final CategoriesRepository categoriesRepository;
    @Override
    public Dish convert(DishDto dishDto) {
        Dish dish=new Dish();
        dish.setName(dishDto.getName());
        dish.setDescription((dishDto.getDescription()));
        dish.setCooking_time_minute(dishDto.getCooking_time_minute());
        Category category = categoriesRepository.findById(dishDto.getCategoryId()).orElse(null);
        dish.setCategory(category);
        return dish;
    }
}
