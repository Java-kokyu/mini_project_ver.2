package com.coffee.miniproject.model.beverage;

import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Unit {
    ML(1.0, "ml", 1L),
    G(1.0, "g", 2L),
    OZ(30.0, "oz", 3L),
    TSP(3.7, "tsp", 4L),
    DR(0.2, "dr", 5L);


    private double unitVolume;
    private String unit;
    private Long code;

    Unit(double unitVolume, String unit, Long code) {
        this.unitVolume = unitVolume;
        this.unit = unit;
        this.code = code;
    }

    public static Unit ofCode(Long dbData) {
        return Arrays.stream(Unit.values())
                .filter(v -> v.getCode().equals(dbData))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하는 카테고리 단위 코드입니다."));
    }
}
