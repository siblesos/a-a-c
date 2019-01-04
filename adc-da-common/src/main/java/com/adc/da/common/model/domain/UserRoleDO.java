package com.adc.da.common.model.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色
 *
 */
@Data
public class UserRoleDO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;
}
