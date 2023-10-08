package com.cook.book.cook.controllers;

import com.cook.book.cook.dtos.DishDto;
import com.cook.book.cook.services.impl.DishServiceImpl;
import com.cook.book.cook.services.impl.MeasurementServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final DishServiceImpl dishService;
    private final MeasurementServiceImpl measurementService;

    @GetMapping
    public String getInfoCategoriesAndCountDishes(Model model) {
        model.addAttribute("categories", dishService.getCategoriesAndCountDishes());
        return "adminPageStart";
    }

    @GetMapping("addDish/{categoryId}")
    public String addDish(@PathVariable Long categoryId, Model model) {
        model.addAttribute("categoryId", categoryId);
        return "adminAddDish";
    }

    @PostMapping("/addNewDish")
    public String save(@ModelAttribute("dish") DishDto dish,
                       @RequestParam("file") MultipartFile file) throws IOException {
//        DishCategory dishCategoryById = dishCategoryService.getDishCategoryById(dishCategoryId);
//        dish.setDishCategory(dishCategoryById);
//        dishService.addOrUpdateDish(dish, file);
        return "redirect:/api/v1/admin";
    }

    @GetMapping("/createIngredient")
    public String addIngredient(Model model) {
        model.addAttribute("measurements", measurementService.getAllMeasurementDto());
        return "adminCreateIngredient";
    }
}

