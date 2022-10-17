package com.coffee.miniproject.controller;

import com.coffee.miniproject.common.Message;
import com.coffee.miniproject.model.beverage.Ingredient;
import com.coffee.miniproject.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BeverageController {

    private final IngredientRepository ingredientRepository;

    @GetMapping("/api/ingredient")
    public ResponseEntity<Message> getIngredient() {
        Message message = new Message(true, "모든 재료를 조회하였습니다.", ingredientRepository.findAll());
        return ResponseEntity.ok(message);
    }

    @PostMapping("/api/ingredient")
    public ResponseEntity<Message> postIngredient(@RequestBody Ingredient.Request request) {
        Ingredient ingredient = ingredientRepository.save(Ingredient.builder().request(request).build());
        Message message = new Message(true, "재료를 등록하였습니다.", ingredient);
        return ResponseEntity.ok(message);
    }
}
