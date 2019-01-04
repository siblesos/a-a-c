package com.adc.da.common.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页模型
 *

 */
@Data
public class Page implements Serializable {
    /**
     * 总条数
     */
    private int total;

    /**
     * 集合
     */
    private List<?> rows;
}
