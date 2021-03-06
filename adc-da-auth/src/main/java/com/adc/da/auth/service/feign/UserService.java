package com.adc.da.auth.service.feign;

import com.adc.da.common.model.domain.RoleDO;
import com.adc.da.common.model.domain.UserDO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 用户服务
 *

 */
@FeignClient(name = "soraka-admin")
public interface UserService {
    /**
     * 根据用户名获取用户详情
     *
     * @param username 用户名
     * @return UserDO
     */
    @GetMapping("user/username/{username}")
    UserDO getByUsername(@PathVariable("username") String username);

    /**
     * 获取用户角色详情
     *
     * @param id 用户ID
     * @return UserDO
     */
    @GetMapping("user/{id}/role")
    List<RoleDO> getUserRole(@PathVariable("id") Long id);
}
