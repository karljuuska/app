package com.kadaja.shopsystem.service;

import com.kadaja.shopsystem.dto.IngredientDTO;
import com.kadaja.shopsystem.model.Ingredient;

import java.util.List;

public interface ShopService {

    void createIngridient(IngredientDTO ingredient);
    void updateIngridient(Long id, IngredientDTO ingredient);
    List<Ingredient> getAllIngredients();
    void persistIngredients();
}
