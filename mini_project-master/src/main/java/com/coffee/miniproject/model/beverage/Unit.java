package com.coffee.miniproject.model.beverage;

import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Unit {
    ML(1.0, 1L), OZ(30.0, 2L), TSP(3.7, 3L), DR(0.2, 4L);


    private double unit;
    private Long code;

    @Builder
    Unit(double unit, Long code) {
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
