package com.cook.book.cook.controllers;


import com.cook.book.cook.dtos.CategoryDto;
import com.cook.book.cook.services.impl.DishServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DishServiceImpl dishService;

    @Test
    public void getInfoCategoriesAndCountDishes() throws Exception {
        this.mockMvc
                .perform(
                        get("/api/v1/admin")
                                .with(SecurityMockMvcRequestPostProcessors.user("dima").roles("ADMIN"))
                                .with(csrf())
                )
                .andExpect(status().isOk());
    }

    @Test
    public void addDish() throws Exception {
        when(dishService.getCategoriesAndCountDishes()).thenReturn(List.of(new CategoryDto()));
        this.mockMvc
                .perform(
                        get("/api/v1/admin/addDish/1")
                                .with(SecurityMockMvcRequestPostProcessors.user("duke").roles("ADMIN"))
                                .with(csrf())
                )
                .andExpect(status().isOk())
                .andExpect(view().name("adminAddDish"));

    }
}