package com.coffee.miniproject.controller;

import com.coffee.miniproject.common.Message;
import com.coffee.miniproject.model.Member;
import com.coffee.miniproject.model.Post;
import com.coffee.miniproject.model.PostRecipe;
import com.coffee.miniproject.service.CommonService;
import com.coffee.miniproject.service.PostRecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostRecipeController {

    private final PostRecipeService postRecipeService;
    private final CommonService commonService;

    @PostMapping("/api/posts/recipe")
    public ResponseEntity<Message> postRecipe(@RequestBody PostRecipe.Request request) {
        Member member = commonService.getUser();
        PostRecipe.Response response = postRecipeService.postRecipe(member, request);
        Message message = new Message(true, "커피 레시피를 성공적으로 등록하였습니다.", response);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/api/posts/recipe/{id}")
    public ResponseEntity<Message> getRecipeDetail(@PathVariable Long id) {
        Member member = commonService.getUser();
        PostRecipe.Response response = postRecipeService.getRecipeDetail(member, id);
        Message message = new Message(true, "커피 레시피를 성공적으로 조회하였습니다.", response);
        return ResponseEntity.ok(message);
    }
}
