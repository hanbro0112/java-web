package com.sky.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "員工登錄返回數據格式")
public class EmployeeLoginVO implements Serializable {

    @Schema(description = "主鍵值")
    private Long id;

    @Schema(description = "用戶名")
    private String username;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "jwt令牌")
    private String token;


}
