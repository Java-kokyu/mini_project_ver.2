package com.coffee.miniproject.model.beverage;

import com.coffee.miniproject.converter.CategoryConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class Ingredient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Convert(converter = CategoryConverter.class)
    private Category category;

    @Column(unique = true)
    private String ingredient;

    @Builder
    public Ingredient(Request request) {
        this.ingredient = request.getIngredient();
        this.category = Category.ofCode(request.getCategoryCode());
    }

    @Getter
    @RequiredArgsConstructor
    public static class Request {
        Long categoryCode;
        String ingredient;

        @Builder
        public Request(Long categoryCode, String ingredient) {
            this.ingredient = ingredient;
            this.categoryCode = categoryCode;
        }
    }
}
