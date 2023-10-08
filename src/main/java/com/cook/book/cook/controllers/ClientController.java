package com.cook.book.cook.controllers;

import com.cook.book.cook.dtos.DishDto;
import com.cook.book.cook.dtos.IngredientDto;
import com.cook.book.cook.services.impl.DishServiceImpl;
import com.cook.book.cook.services.impl.ImageServiceImpl;
import com.cook.book.cook.services.impl.IngredientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final DishServiceImpl dishService;
    private final ImageServiceImpl imageService;
    private final IngredientServiceImpl ingredientService;
    @GetMapping
    public String getInfoCategoriesAndCountDishes(Model model){
        model.addAttribute("categories",dishService.getCategoriesAndCountDishes());
        return "startPageClient";

    }

    @GetMapping("/{categoryId}")
    public String getAllDishByCategory(@PathVariable Long categoryId, Model model){
        List<DishDto> allDishByCategory = dishService.getAllDishByCategory(categoryId);
        model.addAttribute("dishes",allDishByCategory);
        return "clientDishByCategory";
    }
    @GetMapping("/dish/{dishId}")
    public String getInfoDish(@PathVariable Long dishId, Model model){
        DishDto dishDto = dishService.getDishById(dishId);
        model.addAttribute("dish",dishDto);
        Long imageId = imageService.getImageIdFromDish(dishDto);
        model.addAttribute("imageId", imageId);
        List<IngredientDto> ingredients = ingredientService.getIngredientsByDish(dishDto.getId());
        model.addAttribute("ingredients",ingredients);
        return "clientInfoDish";
    }
}
