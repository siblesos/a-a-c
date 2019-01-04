package com.adc.da.system.service;

import com.adc.da.common.model.domain.UserRoleDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色
 *
 */
@Service
public interface UserRoleService {

    /**
     * 获取用户角色ID集合
     *
     * @param userId 用户主键
     * @return List<Long>
     */
    List<Long> findRoleIdsByUserId(Long userId);

    /**
     * 删除用户角色关系
     *
     * @param userId 用户主键
     * @return 受影响行数
     */
    Integer deleteByUserId(Long userId);

    /**
     * 批量保存用户角色关系
     *
     * @param userRoles 用户角色
     * @return 受影响行数
     */
    Integer batchSave(List<UserRoleDO> userRoles);
}
