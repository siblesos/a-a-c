package com.adc.da.system.service.impl;

import com.adc.da.system.dao.UserRoleDAO;
import com.adc.da.system.service.UserRoleService;
import com.adc.da.common.model.domain.UserRoleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户角色
 *

 */
@Transactional(rollbackFor = {RuntimeException.class})
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDAO userRoleDAO;
    /**
     * 获取用户角色ID集合
     *
     * @param userId 用户主键
     * @return List<Long>
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public List<Long> findRoleIdsByUserId(Long userId) {
        return userRoleDAO.findRoleIdsByUserId(userId);
    }

    /**
     * 删除用户角色关系
     *
     * @param userId 用户主键
     * @return 受影响行数
     */
    @Override
    public Integer deleteByUserId(Long userId) {
        return userRoleDAO.deleteByUserId(userId);
    }

    /**
     * 批量保存用户角色关系
     *
     * @param userRoles 用户角色
     * @return 受影响行数
     */
    @Override
    public Integer batchSave(List<UserRoleDO> userRoles) {
        return userRoleDAO.batchSave(userRoles);
    }
}
