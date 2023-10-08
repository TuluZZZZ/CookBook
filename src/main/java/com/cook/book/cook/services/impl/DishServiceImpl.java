package com.cook.book.cook.services.impl;

import com.cook.book.cook.convertors.DishDtoToDishConvertor;
import com.cook.book.cook.convertors.DishToDishDtoConvertor;
import com.cook.book.cook.dtos.CategoryDto;
import com.cook.book.cook.dtos.DishDto;
import com.cook.book.cook.models.Category;
import com.cook.book.cook.models.Dish;
import com.cook.book.cook.models.Image;
import com.cook.book.cook.repositories.CategoriesRepository;
import com.cook.book.cook.repositories.DishRepository;
import com.cook.book.cook.services.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final CategoriesRepository categoriesRepository;
    private final DishRepository dishRepository;
    private final DishDtoToDishConvertor dishDtoToDishConvertor;
    private final DishToDishDtoConvertor dishToDishDtoConvertor;

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

    @Override
    public DishDto saveDish(DishDto dishDto, MultipartFile file) throws IOException {
        Dish dish = dishDtoToDishConvertor.convert(dishDto);
        Image image = convert(file);
        image.setDish(dish);
        List<Image> images = new ArrayList<>();
        images.add(image);
        dish.setImages(images);
        Dish save = dishRepository.save(dish);
        return dishToDishDtoConvertor.convert(save);
    }

    @Override
    public List<DishDto> getAllDishByCategory(Long categoryId) {
        Category category = categoriesRepository.findById(categoryId).orElse(null);
        return dishRepository.findAllByCategory(category).stream().map(dish -> dishToDishDtoConvertor.convert(dish)).toList();
    }

    @Override
    public DishDto getDishById(Long dishId) {
        Dish dish = dishRepository.findById(dishId).orElse(null);
        return dishToDishDtoConvertor.convert(dish);
    }

    private Image convert(MultipartFile multipartFile) throws IOException {
        Image image = new Image();
        image.setName(multipartFile.getName());
        image.setOriginalFileName(multipartFile.getOriginalFilename());
        image.setContentType(multipartFile.getContentType());
        image.setSize(multipartFile.getSize());
        image.setBytes(multipartFile.getBytes());
        return image;
    }
}


