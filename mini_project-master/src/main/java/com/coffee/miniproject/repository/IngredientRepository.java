package com.coffee.miniproject.repository;

import com.coffee.miniproject.model.beverage.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
