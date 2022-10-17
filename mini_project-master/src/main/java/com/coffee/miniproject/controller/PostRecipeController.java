package com.coffee.miniproject.controller;

import com.coffee.miniproject.common.Message;
import com.coffee.miniproject.model.Member;
import com.coffee.miniproject.model.Recipe;
import com.coffee.miniproject.service.CommonService;
import com.coffee.miniproject.service.PostRecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostRecipeController {

    private final PostRecipeService postRecipeService;
    private final CommonService commonService;

    @PostMapping("/api/posts/recipe")
    public ResponseEntity<Message> postRecipe(@RequestBody Recipe.Request request) {
        Member member = commonService.getUser();
        Recipe.ResponseDetail response = postRecipeService.postRecipe(member, request);
        Message message = new Message(true, "커피 레시피를 성공적으로 등록하였습니다.", response);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/api/posts/recipe")
    public ResponseEntity<Message> getPostRecipe() {
        List<Recipe.Response> responseList = postRecipeService.getPostRecipe();
        Message message = new Message(true, "레시피 게시물 전체조회에 성공하셨습니다.", responseList);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/api/posts/recipe/{id}")
    public ResponseEntity<Message> getRecipeDetail(@PathVariable Long id) {
        Recipe.ResponseDetail response = postRecipeService.getRecipeDetail(id);
        Message message = new Message(true, "커피 레시피를 성공적으로 조회하였습니다.", response);
        return ResponseEntity.ok(message);
    }
}
