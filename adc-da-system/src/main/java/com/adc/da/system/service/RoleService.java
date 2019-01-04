package com.adc.da.system.service;

import com.adc.da.system.model.dto.QueryParam;
import com.adc.da.common.model.domain.RoleDO;
import com.adc.da.common.model.dto.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色

 */
@Service
public interface RoleService {
    /**
     * 根据主键获取角色
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
     * 获取所有角色
     *
     * @return List<RoleDO>
     */
    List<RoleDO> findAll();

    /**
     * 查询角色列表页
     *
     * @param queryParam 查询参数
     * @return {@link Page}
     */
    Page findPage(QueryParam queryParam);

    /**
     * 新增角色
     *
     * @param roleDO
     * @return true 成功 false 失败
     */
    boolean save(RoleDO roleDO);

    /**
     * 更新角色
     *
     * @param roleDO
     * @return true 成功 false 失败
     */
    boolean update(RoleDO roleDO);

    /**
     * 删除角色
     *
     * @param id 角色ID
     * @return true 成功 false 失败
     */
    boolean delete(Long id);
}
