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

    public BeverageIngredient(Ingredient ingredient, Beverage beverage, Request request) {
        this.ingredient = ingredient;
        this.volume = request.getVolume();
        this.unit = Unit.ofCode(request.getUnitCode());
        this.beverage = beverage;
    }


    @Getter
    @RequiredArgsConstructor
    public static class Request {
        private Long ingredientId;
        private Long categoryCode;
        private int volume;
        private Long unitCode;

        @Builder
        public Request(Long ingredientId, Long categoryCode, int volume, Long unitCode) {
            this.ingredientId = ingredientId;
            this.categoryCode = categoryCode;
            this.volume = volume;
            this.unitCode = unitCode;
        }
    }

    @Getter
    public static class Response {
        private final Long ingredientId;
        private final String category;
        private final String ingredient;
        private final int volume;
        private final double convertedVolume;
        private final String unit;

        @Builder
        public Response(BeverageIngredient beverageIngredient) {
            this.ingredientId = beverageIngredient.getIngredient().getId();
            this.category = beverageIngredient.getIngredient().getCategory().getCategory();
            this.ingredient = beverageIngredient.getIngredient().getIngredient();
            this.volume = beverageIngredient.getVolume();
            this.convertedVolume = beverageIngredient.getVolume() * beverageIngredient.getUnit().getUnitVolume();
            this.unit = beverageIngredient.getUnit().getUnit();
        }
    }
}
