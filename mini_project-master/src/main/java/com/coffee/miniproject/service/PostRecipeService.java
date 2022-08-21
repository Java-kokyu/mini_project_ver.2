package com.coffee.miniproject.service;

import com.coffee.miniproject.model.Member;
import com.coffee.miniproject.model.PostRecipe;
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

    public PostRecipe.ResponseDetail postRecipe(Member member, PostRecipe.Request request) {
        // 1. Beverage 등록
        Beverage beverage = saveBeverage(request.getBeverage(), request.getSizeCode());
        // 2. Beverage Ingredient 등록
        List<BeverageIngredient.Response> beverageIngredientResponses = saveBeverageIngredient(beverage, request.getIngredients());
        // 3. Post 등록
        PostRecipe postRecipe = savePostRecipe(member, beverage, request.getTitle(), request.getContents(), request.getImg(), request.getSizeCode());

        return new PostRecipe.ResponseDetail(postRecipe, beverageIngredientResponses);
    }

    public List<PostRecipe.Response> getPostRecipe() {
        List<PostRecipe> postRecipes = postRecipeRepository.findAll();
        List<PostRecipe.Response> responses = new ArrayList<>();
        for(PostRecipe postRecipe : postRecipes) {
            responses.add(new PostRecipe.Response(postRecipe));
        }
        return responses;
    }

    public PostRecipe.ResponseDetail getRecipeDetail(Long id) {
        List<BeverageIngredient.Response> beverageIngredientResponses = new ArrayList<>();
        PostRecipe postRecipe = postRecipeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 아이디입니다.")
        );
        for(BeverageIngredient beverageIngredient : postRecipe.getBeverage().getBeverageIngredients()) {
            beverageIngredientResponses.add(new BeverageIngredient.Response(beverageIngredient));
        }
        return new PostRecipe.ResponseDetail(postRecipe, beverageIngredientResponses);
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
    public PostRecipe savePostRecipe(Member member, Beverage beverage, String title, String contents, String img, Long sizeCode) {
        return postRecipeRepository.save(new PostRecipe(member, beverage, title, contents, img, sizeCode));
    }
}
