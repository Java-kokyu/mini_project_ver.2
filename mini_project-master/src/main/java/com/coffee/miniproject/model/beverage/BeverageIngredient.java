package com.coffee.miniproject.model.beverage;

import com.coffee.miniproject.converter.UnitConverter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Getter
@RequiredArgsConstructor
@Entity
public class BeverageIngredient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private int volume;

    @Convert(converter = UnitConverter.class)
    private Unit unit;

    @OneToOne
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "BEVERAGE_ID")
    @JsonBackReference(value = "beverage-fk")
    private Beverage beverage;

    public BeverageIngredient(Request request) {
        this.id = request.getIngredientId();
        this.volume = request.getVolume();
        this.unit = Unit.ofCode(request.getUnitCode());
    }


    @Getter
    @RequiredArgsConstructor
    public static class Request {
        private Long ingredientId;
        private Long categoryCode;
        private String ingredient;
        private int volume;
        private Long unitCode;

        @Builder
        public Request(Long ingredientId, Long categoryCode, String ingredient, int volume, Long unitCode) {
            this.ingredientId = ingredientId;
            this.categoryCode = categoryCode;
            this.ingredient = ingredient;
            this.volume = volume;
            this.unitCode = unitCode;
        }
    }
}
