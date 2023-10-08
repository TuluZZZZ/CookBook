package com.cook.book.cook.controllers;

import com.cook.book.cook.dtos.DishDto;
import com.cook.book.cook.dtos.IngredientDto;
import com.cook.book.cook.services.impl.DishServiceImpl;
import com.cook.book.cook.services.impl.ImageServiceImpl;
import com.cook.book.cook.services.impl.IngredientServiceImpl;
import com.cook.book.cook.services.impl.MeasurementServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
    private final DishServiceImpl dishService;
    private final MeasurementServiceImpl measurementService;
    private final IngredientServiceImpl ingredientService;
    private final ImageServiceImpl imageService;

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
        dishService.saveDish(dish, file);
        return "redirect:/api/v1/admin";
    }

    @GetMapping("/createIngredient")
    public String createIngredient(Model model) {
        model.addAttribute("measurements", measurementService.getAllMeasurementDto());
        return "adminCreateIngredient";
    }

    @PostMapping("/createIngredient")
    public String createIngredient(@ModelAttribute("ingredient") IngredientDto ingredientDto){
        ingredientService.createIngredient(ingredientDto);
        return "redirect:/api/v1/admin/createIngredient";
    }
    @GetMapping("/{categoryId}")
    public String getAllDishByCategory(@PathVariable Long categoryId, Model model){
        List<DishDto> allDishByCategory = dishService.getAllDishByCategory(categoryId);
        model.addAttribute("dishes",allDishByCategory);
        return "adminDishByCategory";
    }
    @GetMapping("/dish/{dishId}")
    public String getInfoDish(@PathVariable Long dishId, Model model){
        DishDto dishDto = dishService.getDishById(dishId);
        model.addAttribute("dish",dishDto);
        Long imageId = imageService.getImageIdFromDish(dishDto);
        model.addAttribute("imageId", imageId);
        List<IngredientDto> ingredients = ingredientService.getIngredientsByDish(dishDto.getId());
        model.addAttribute("ingredients",ingredients);
        return "adminInfoDish";
    }
    @GetMapping("/addIngredient/{dishId}")
    public String addIngredient(@PathVariable Long dishId, Model model) {
        model.addAttribute("dishId",dishId);
        model.addAttribute("measurements", measurementService.getAllMeasurementDto());
        model.addAttribute("ingredients",ingredientService.getAll());

//        model.addAttribute("measurements", measurementService.getAllMeasurementDto());
        return "adminAddIngredient";
    }

    @PostMapping("/addIngredient")
    public String addIngredientToDish(@ModelAttribute("ingredient") IngredientDto ingredientDto,
                                      @RequestParam(name = "dishId") Long dishId){
        ingredientService.addIngredient(ingredientDto,dishId);
        return "redirect:/api/v1/admin/dish/"+dishId;

    }

}

