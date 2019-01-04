package com.adc.da.common.model.dto;


import com.adc.da.common.exception.BuzCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回值
 *
 */
@Data
public class R implements Serializable {
    /**
     * 返回码
     */
    private int code = BuzCode.SUCCEED.getCode();

    /**
     * 返回信息
     */
    private String message = BuzCode.SUCCEED.getMessage();

    /**
     * 返回数据
     */
    private Object data;

    public static R success() {
        return new R();
    }

    public static R fail() {
        return new R(BuzCode.FAILED.getCode(), BuzCode.FAILED.getMessage());
    }

    public static R operate(boolean isSucceed) {
        return isSucceed ? success() : fail();
    }

    public R() {
    }

    public R(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public R(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
