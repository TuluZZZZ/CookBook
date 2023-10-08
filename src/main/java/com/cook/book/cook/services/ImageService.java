package com.cook.book.cook.services;

import com.cook.book.cook.dtos.DishDto;

public interface ImageService {
    Long getImageIdFromDish(DishDto dishDto);
}

