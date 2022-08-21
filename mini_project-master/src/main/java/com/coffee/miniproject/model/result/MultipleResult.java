package com.coffee.miniproject.model.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MultipleResult<T> extends Result {
    // Result를 상속받아 직렬화를 기본적으로 사용
    // 다중결과 값을 표현하기 위해 List 사용
    private List<T> datas;
}
