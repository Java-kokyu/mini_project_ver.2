package com.coffee.miniproject.model.beverage;

import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Size {
    SHORT(237, 1L),
    TALL(355, 2L),
    GRANDE(473, 3L),
    VENTI(591, 4L);

    private final int volume;
    private final Long code;

    @Builder
    Size(int volume, Long code) {
        this.volume = volume;
        this.code = code;
    }

    public static Size ofCode(Long dbData) {
        return Arrays.stream(Size.values())
                .filter(v -> v.getCode().equals(dbData))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 음료 사이즈 코드입니다."));
    }
}
