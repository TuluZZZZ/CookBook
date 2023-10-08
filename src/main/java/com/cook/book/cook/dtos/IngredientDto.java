package com.cook.book.cook.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {
    private Long id;
    private String ingredientName;
    private Long measurementId;
    private String measurementName;
    private Integer quantity;
}
