package com.coffee.miniproject.model.beverage;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Category {
    BASE("원액", 1L),
    MILK("우유", 2L),
    WATER("물/얼음", 3L),
    CREAM("크림", 4L),
    SYRUP("시럽", 5L);

    private final String category;
    private final Long code;

    Category(String category, Long code) {
        this.category = category;
        this.code = code;
    }

    public static Category ofCode(Long dbData) {
        return Arrays.stream(Category.values())
                .filter(v -> v.getCode().equals(dbData))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카데고리 코드입니다."));
    }
}
