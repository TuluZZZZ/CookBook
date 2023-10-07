package com.cook.book.cook.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DishDto {
    private Long id;
    private String name;
    private String description;
    private Integer cooking_time_minute;
    private Long categoryId;
}
