package com.sky.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "員工登錄傳輸數據模型")
public class EmployeeLoginDTO implements Serializable {

    @Schema(description = "用戶名")
    private String username;

    @Schema(description = "密碼")
    private String password;
}
