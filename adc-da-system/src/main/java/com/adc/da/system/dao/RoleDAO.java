package com.adc.da.system.dao;

import com.adc.da.system.model.dto.QueryParam;
import com.adc.da.common.model.domain.RoleDO;

import java.util.List;

/**
 * 角色

 */
public interface RoleDAO {
    /**
     * 通过主键获取角色
     *
     * @param id 主键
     * @return {@link RoleDO}
     */
    RoleDO get(Long id);

    /**
     * 获取用户角色集合
     *
     * @param userId 用户主键
     * @return List<RoleDO>
     */
    List<RoleDO> findByUserId(Long userId);

    /**
     * 查询角色列表
     *
     * @param param 查询参数
     * @return List<RoleDO>
     */
    List<RoleDO> find(QueryParam param);

    /**
     * 查询角色列表条数
     *
     * @param param 查询参数
     * @return {@link Integer}
     */
    Integer count(QueryParam param);

    /**
     * 新增角色
     *
     * @param roleDO
     * @return true 成功 false 失败
     */
    Integer save(RoleDO roleDO);

    /**
     * 更新角色
     *
     * @param roleDO
     * @return true 成功 false 失败
     */
    Integer update(RoleDO roleDO);

    /**
     * 删除角色
     *
     * @param id 角色ID
     * @return true 成功 false 失败
     */
    Integer delete(Long id);
}
