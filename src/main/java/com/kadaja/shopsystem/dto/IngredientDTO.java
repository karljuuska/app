package com.kadaja.shopsystem.dto;

public class IngredientDTO {
    private final Integer amount;
    private final String name;

    private final Float price;

    public IngredientDTO(Integer amount, String name, Float price) {
        this.amount = amount;
        this.name = name;
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }
}
