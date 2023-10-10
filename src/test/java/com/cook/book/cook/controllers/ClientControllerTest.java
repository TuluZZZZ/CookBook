package com.cook.book.cook.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInfoCategoriesAndCountDishes() throws Exception {
        this.mockMvc
                .perform(
                        get("/api/v1/clients")
                                .with(SecurityMockMvcRequestPostProcessors.user("duke").roles("USER"))
                                .with(csrf())
                )
                .andExpect(status().isOk())
                .andExpect(view().name("startPageClient"))
                .andExpect(model().attributeExists("categories"));

    }
}