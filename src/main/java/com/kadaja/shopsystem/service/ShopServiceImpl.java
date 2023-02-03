package com.kadaja.shopsystem.service;

import com.kadaja.shopsystem.dto.IngredientDTO;
import com.kadaja.shopsystem.model.Ingredient;
import com.kadaja.shopsystem.repository.ShopRepository;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    @Transactional
    public void createIngridient(IngredientDTO ingredient) {
        Ingredient toCreate = new Ingredient();
        toCreate.setPrice(ingredient.getPrice());
        toCreate.setName(ingredient.getName());
        toCreate.setAmount(ingredient.getAmount());
        shopRepository.save(toCreate);
    }

    @Override
    @Transactional
    public void updateIngridient(Long id, IngredientDTO ingredient) {
        Ingredient exisiting = shopRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Ingredient with id " + id + " does not exist!"));
        exisiting.setAmount(ingredient.getAmount());
        exisiting.setName(ingredient.getName());
        exisiting.setPrice(ingredient.getPrice());
        shopRepository.save(exisiting);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return shopRepository.findAll();
    }

    public void persistIngredients() {

        long entities = shopRepository.count();

        if (entities != 9){


            List<List<String>> ingredients = List.of(
                    List.of("Brownie", "0.65", "48"),
                    List.of("Muffin", "1.00", "36"),
                    List.of("Cake Pop", "1.35", "24"),
                    List.of("Apple tart", "1.50", "60"),
                    List.of("Water", "1.50", "30"),
                    List.of("Shirt", "2.00", "0"),
                    List.of("Pants", "3.00", "0"),
                    List.of("Jacket", "4.00", "0"),
                    List.of("Toy", "1.00", "0")
            );
            System.out.println(entities);
            if (entities == 0){

                List<Ingredient> insertedIngredients = new ArrayList<>();

                for (List<String> _ingredient: ingredients) {

                    Ingredient ingredient = new Ingredient();

                    ingredient.setName(_ingredient.get(0));
                    ingredient.setPrice(Float.parseFloat(_ingredient.get(1)));
                    ingredient.setAmount(Integer.parseInt(_ingredient.get(2)));

                    insertedIngredients.add(ingredient);
                }

                shopRepository.saveAll(insertedIngredients);

            }else{
                throw new QueryException("Wrong amount of entities in database(drop or empty the table)");
            }

        }

    }

}
