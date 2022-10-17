package com.coffee.miniproject.service;

import com.coffee.miniproject.model.Member;
import com.coffee.miniproject.model.Recipe;
import com.coffee.miniproject.model.beverage.Beverage;
import com.coffee.miniproject.model.beverage.BeverageIngredient;
import com.coffee.miniproject.model.beverage.Category;
import com.coffee.miniproject.model.beverage.Ingredient;
import com.coffee.miniproject.repository.BeverageIngredientRepository;
import com.coffee.miniproject.repository.BeverageRepository;
import com.coffee.miniproject.repository.IngredientRepository;
import com.coffee.miniproject.repository.PostRecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostRecipeService {
    private final BeverageIngredientRepository beverageIngredientRepository;
    private final BeverageRepository beverageRepository;
    private final PostRecipeRepository postRecipeRepository;
    private final IngredientRepository ingredientRepository;

    public Recipe.ResponseDetail postRecipe(Member member, Recipe.Request request) {
        // 1. Beverage 등록
        Beverage beverage = saveBeverage(request.getBeverage(), request.getSizeCode());
        // 2. Beverage Ingredient 등록
        List<BeverageIngredient.Response> beverageIngredientResponses = saveBeverageIngredient(beverage, request.getIngredients());
        // 3. Post 등록
        Recipe recipe = savePostRecipe(member, beverage, request.getTitle(), request.getContents(), request.getImg(), request.getSizeCode());

        return new Recipe.ResponseDetail(recipe, beverageIngredientResponses);
    }

    public List<Recipe.Response> getPostRecipe() {
        List<Recipe> recipes = postRecipeRepository.findAll();
        List<Recipe.Response> responses = new ArrayList<>();
        for(Recipe recipe : recipes) {
            responses.add(new Recipe.Response(recipe));
        }
        return responses;
    }

    public Recipe.ResponseDetail getRecipeDetail(Long id) {
        List<BeverageIngredient.Response> beverageIngredientResponses = new ArrayList<>();
        Recipe recipe = postRecipeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        for(BeverageIngredient beverageIngredient : recipe.getBeverage().getBeverageIngredients()) {
            beverageIngredientResponses.add(new BeverageIngredient.Response(beverageIngredient));
        }
        return new Recipe.ResponseDetail(recipe, beverageIngredientResponses);
    }
    @Transactional
    public List<BeverageIngredient.Response> saveBeverageIngredient(Beverage beverage, List<BeverageIngredient.Request> requests) {
        //1. Ingredient 검색
        List<BeverageIngredient.Response> responses = new ArrayList<>();
        for(BeverageIngredient.Request request : requests) {
            Ingredient ingredient = ingredientRepository.findByCategoryAndId(Category.ofCode(request.getCategoryCode()), request.getIngredientId());
            BeverageIngredient beverageIngredient = beverageIngredientRepository.save(new BeverageIngredient(ingredient, beverage, request));
            responses.add(new BeverageIngredient.Response(beverageIngredient));
        }
        return responses; // 1. response 생성 2. beverage 등록
    }

    public Beverage saveBeverage(String beverage, Long sizeCode) {
        return beverageRepository.save(new Beverage(beverage, sizeCode));
    }
    @Transactional
    public Recipe savePostRecipe(Member member, Beverage beverage, String title, String contents, String img, Long sizeCode) {
        return postRecipeRepository.save(new Recipe(member, beverage, title, contents, img, sizeCode));
    }
}
