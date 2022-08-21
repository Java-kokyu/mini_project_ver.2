package com.coffee.miniproject.model.result;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Result implements Serializable {
    // Result 객체 직렬화 사용
    // Data를 출력해서 표현해야하는 객체로서 '직렬화'
    private boolean success; // 응답 성공 여부
    private int code;        // 응답 코드
    private String message;  // 응답 메시지
}
