package com.kadaja.shopsystem.repository;

import com.kadaja.shopsystem.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Ingredient, Long> {
}
