package com.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code; // 響應狀態碼 1: 成功 0:失敗
    private String msg;
    private Object data;

    // 增刪改 成功響應
    public static Result success() { return new Result(1, "success", null); }
    // 查詢 成功響應
    public static Result success(Object data) { return new Result(1, "success", data); }
    // 失敗響應
    public static Result error(String msg) { return new Result(0, msg, null); }
}
