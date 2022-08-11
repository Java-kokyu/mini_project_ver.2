package com.coffee.miniproject.controller;

import com.coffee.miniproject.common.Message;
import com.coffee.miniproject.model.PostRecipe;
import com.coffee.miniproject.service.PostRecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostRecipeController {

    private final PostRecipeService postRecipeService;

    @PostMapping("/api/posts/recipe")
    public ResponseEntity<Message> postRecipe(@RequestBody PostRecipe.Request request) {
        postRecipeService.postRecipe(request);
    }
}
