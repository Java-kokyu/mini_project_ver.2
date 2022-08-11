package com.coffee.miniproject.service;

import com.coffee.miniproject.model.PostRecipe;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostRecipeService {
    @Transactional
    public void postRecipe(PostRecipe.Request request) {
        // 1. Beverage Ingredient 등록
        // 2. Beverage 등록
        // 3. Post 등록
    }
}
