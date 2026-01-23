package com.sky.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 後端統一返回結果
 */
@Data
public class Result<T> implements Serializable {

    private Integer code; // 狀態碼: 1成功，0和其他數字為失敗
    private String msg; // 錯誤消息
    private T data; // 返回數據

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.code = 1;
        result.data = object;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<T>();
        result.code = 0;
        result.msg = msg;
        return result;
    }

}
