package com.coffee.miniproject.service;

import com.coffee.miniproject.model.result.MultipleResult;
import com.coffee.miniproject.model.result.Result;
import com.coffee.miniproject.model.result.SingleResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    // 단일 결과 처리
    public <T> SingleResult<T> handleSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    // 다중 결과 처리
    public <T> MultipleResult<T> handelListResult(List<T> list) {
        MultipleResult<T> result = new MultipleResult<>();
        result.setDatas(list);
        setSuccessResult(result);
        return result;
    }

    // 결과 처리
    public Result handleSuccessResult() {
        Result result = new Result();
        setSuccessResult(result);
        return result;
    }

   // 실패 결과 처리
    public Result handleFailResult(int code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    // 성공 결과 처리
    public <T> void setSuccessResult(Result result) {
        result.setSuccess(true);
        result.setCode(200);
        result.setMessage("Request 200 : Success");
    }
}
