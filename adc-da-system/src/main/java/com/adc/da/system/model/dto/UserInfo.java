package com.adc.da.system.model.dto;

import com.adc.da.common.model.domain.UserDO;
import lombok.Data;

import java.util.List;

/**
 * 系统用户信息

 */
@Data
public class UserInfo extends BaseDTO {
    /**
     * 用户信息
     */
    private UserDO user;

    /**
     * 权限标识集合
     */
    private List<String> permissions;
}
