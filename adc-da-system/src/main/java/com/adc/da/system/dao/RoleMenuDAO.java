package com.adc.da.system.dao;

import com.adc.da.common.model.domain.RoleMenuDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色菜单

 */
public interface RoleMenuDAO {

    /**
     * 获取角色菜单ID集合
     *
     * @param roleId 角色主键
     * @return List<Long>
     */
    List<Long> findMenuIdsByRoleId(Long roleId);

    /**
     * 删除角色菜单关系
     *
     * @param roleId 角色主键
     * @return 受影响行数
     */
    Integer deleteByRoleId(Long roleId);

    /**
     * 批量保存角色菜单关系
     *
     * @param roleMenus 角色菜单
     * @return 受影响行数
     */
    Integer batchSave(@Param("roleMenus") List<RoleMenuDO> roleMenus);
}
