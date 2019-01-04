package com.adc.da.system.service;

import com.adc.da.system.model.dto.QueryParam;
import com.adc.da.common.model.domain.MenuDO;
import com.adc.da.common.model.dto.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单
 */
@Service
public interface MenuService {
    /**
     * 根据主键获取菜单
     *
     * @param id 主键
     * @return {@link MenuDO}
     */
    MenuDO get(Long id);

    /**
     * 获取用户菜单
     *
     * @param userId 用户ID
     * @return List<MenuDO>
     */
    List<MenuDO> findByUserId(Long userId);

    /**
     * 获取用户权限集合
     *
     * @param userId 用户ID
     * @return List<MenuDO>
     */
    List<String> getUserPermission(Long userId);

    /**
     * 获取所有菜单
     *
     * @return List<MenuDO>
     */
    List<MenuDO> findAll();

    /**
     * 查询菜单列表页
     *
     * @param queryParam 查询参数
     * @return {@link Page}
     */
    Page findPage(QueryParam queryParam);

    /**
     * 新增菜单
     *
     * @param menuDO
     * @return true 成功 false 失败
     */
    boolean save(MenuDO menuDO);

    /**
     * 更新菜单
     *
     * @param menuDO
     * @return true 成功 false 失败
     */
    boolean update(MenuDO menuDO);

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return true 成功 false 失败
     */
    boolean delete(Long id);

    /**
     * 查询角色菜单
     *
     * @param roleKeys 角色键值
     * @return 菜单列表
     */
    List<MenuDO> getRoleMenu(List<String> roleKeys);
}
