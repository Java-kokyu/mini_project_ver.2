package com.coffee.miniproject.repository;

import com.coffee.miniproject.model.beverage.BeverageIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeverageIngredientRepository extends JpaRepository<BeverageIngredient, Long> {
}
