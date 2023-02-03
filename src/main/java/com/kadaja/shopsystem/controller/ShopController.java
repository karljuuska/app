package com.kadaja.shopsystem.controller;

import com.kadaja.shopsystem.dto.IngredientDTO;
import com.kadaja.shopsystem.model.Ingredient;
import com.kadaja.shopsystem.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {
    @Autowired
    private ShopService shopService;

    @Operation(summary = "Add an item")

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody IngredientDTO ingredient){
        shopService.createIngridient(ingredient);
        return new ResponseEntity<>("New ingredient is added", HttpStatus.CREATED);
    }

    @Operation(summary = "Update an item")
    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @PathVariable Long id,
            @RequestBody IngredientDTO ingredient) {
        shopService.updateIngridient(id, ingredient);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get all items")
    @GetMapping("/getAll")
    public ResponseEntity<List<Ingredient>> list(){
        return ResponseEntity.ok(shopService.getAllIngredients());
    }


}
