package com.cook.book.cook.controllers;

import com.cook.book.cook.services.impl.DishServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final DishServiceImpl dishService;
    @GetMapping
    public String getInfoCategoriesAndCountDishes(Model model){
        model.addAttribute("categories",dishService.getCategoriesAndCountDishes());
        return "startPageClient";

    }
}
