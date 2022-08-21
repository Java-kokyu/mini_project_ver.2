package com.coffee.miniproject.repository;

import com.coffee.miniproject.model.PostRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRecipeRepository extends JpaRepository<PostRecipe, Long> {
}
