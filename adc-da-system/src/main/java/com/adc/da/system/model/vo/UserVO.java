package com.adc.da.system.model.vo;

import com.adc.da.common.model.domain.UserDO;
import lombok.Data;

/**

 */
@Data
public class UserVO extends UserDO {
    /**
     * 用户密码
     */
    private String newPassword;
}
