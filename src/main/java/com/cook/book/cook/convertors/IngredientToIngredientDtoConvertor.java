package com.cook.book.cook.convertors;

import com.cook.book.cook.dtos.IngredientDto;
import com.cook.book.cook.models.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientDtoConvertor extends Convertor<IngredientDto, Ingredient> {
    @Override
    public IngredientDto convert(Ingredient ingredient) {
        IngredientDto dto=new IngredientDto();
        dto.setId(ingredient.getId());
        dto.setIngredientName(ingredient.getIngredientName());
        dto.setMeasurementId(ingredient.getMeasurement().getId());
        dto.setMeasurementName(ingredient.getMeasurement().getName());
        return dto;
    }
}
