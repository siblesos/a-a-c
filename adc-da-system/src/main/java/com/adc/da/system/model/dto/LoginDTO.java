package com.adc.da.system.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**

 */
@Data
public class LoginDTO {
    /**
     * 用户名
     */
    @NotNull
    private String username;

    /**
     * 密码
     */
    @NotNull
    private String password;

    /**
     * 验证码
     */
    private String captcha;
}
