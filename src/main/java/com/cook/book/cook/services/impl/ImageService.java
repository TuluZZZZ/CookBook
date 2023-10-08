package com.cook.book.cook.services.impl;

import com.cook.book.cook.dtos.DishDto;

public interface ImageService {
    Long getImageIdFromDish(DishDto dishDto);
}

