package com.cook.book.cook.services.impl;

import com.cook.book.cook.dtos.DishDto;
import com.cook.book.cook.models.Dish;
import com.cook.book.cook.repositories.DishRepository;
import com.cook.book.cook.repositories.ImageRepository;
import com.cook.book.cook.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final DishRepository dishRepository;
    private final ImageRepository imageRepository;
    @Override
    public Long getImageIdFromDish(DishDto dishDto) {
        Dish dish = dishRepository.findById(dishDto.getId()).orElse(null);
        return dish.getImages().get(0).getId();
    }
}
