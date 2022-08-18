package com.coffee.miniproject.model.beverage;

import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Size {
    SHORT(237, "SHORT", 1L),
    TALL(355, "TALL", 2L),
    GRANDE(473, "GRANDE",3L),
    VENTI(591, "VENTI",4L);

    private final int sizeVolume;
    private final String size;
    private final Long code;

    Size(int sizeVolume, String size, Long code) {
        this.sizeVolume = sizeVolume;
        this.size = size;
        this.code = code;
    }

    public static Size ofCode(Long dbData) {
        return Arrays.stream(Size.values())
                .filter(v -> v.getCode().equals(dbData))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 음료 사이즈 코드입니다."));
    }
}
