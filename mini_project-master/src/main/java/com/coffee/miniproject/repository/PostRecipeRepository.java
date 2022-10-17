package com.coffee.miniproject.repository;

import com.coffee.miniproject.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRecipeRepository extends JpaRepository<Recipe, Long> {
}
