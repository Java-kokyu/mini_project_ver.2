package com.coffee.miniproject.model.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResult<T> extends Result{
    // Result 상속 직렬화 가능
    // 단일 결과에 대해서 결과값 반환
    private T data;
}
