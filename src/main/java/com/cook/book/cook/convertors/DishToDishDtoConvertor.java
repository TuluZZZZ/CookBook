package com.cook.book.cook.convertors;

import com.cook.book.cook.dtos.DishDto;
import com.cook.book.cook.models.Dish;
import org.springframework.stereotype.Component;

@Component
public class DishToDishDtoConvertor extends Convertor<DishDto, Dish>{
    @Override
    public DishDto convert(Dish dish) {
        DishDto dishDto=new DishDto();
        dishDto.setId(dish.getId());
        dishDto.setName(dish.getName());
        dishDto.setDescription(dish.getDescription());
        dishDto.setCooking_time_minute(dish.getCooking_time_minute());
        dishDto.setCategoryId(dish.getCategory().getId());
        return dishDto;
    }
}
