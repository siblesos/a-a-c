package com.adc.da.system.dao;

import com.adc.da.system.model.dto.QueryParam;
import com.adc.da.common.model.domain.DeptDO;

import java.util.List;

/**
 * 部门
 *

 */
public interface DeptDAO {
    /**
     * 通过主键获取部门
     *
     * @param id 主键
     * @return {@link DeptDO}
     */
    DeptDO get(Long id);

    /**
     * 查询部门列表
     *
     * @param param 查询参数
     * @return List<DeptDO>
     */
    List<DeptDO> find(QueryParam param);

    /**
     * 查询部门列表条数
     *
     * @param param 查询参数
     * @return {@link Integer}
     */
    Integer count(QueryParam param);

    /**
     * 新增部门
     *
     * @param deptDO
     * @return true 成功 false 失败
     */
    Integer save(DeptDO deptDO);

    /**
     * 更新部门
     *
     * @param deptDO
     * @return true 成功 false 失败
     */
    Integer update(DeptDO deptDO);

    /**
     * 删除部门
     *
     * @param id 部门ID
     * @return true 成功 false 失败
     */
    Integer delete(Long id);
}
