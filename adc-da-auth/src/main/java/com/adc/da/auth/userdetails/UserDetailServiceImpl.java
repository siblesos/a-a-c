package com.adc.da.auth.userdetails;


import com.adc.da.auth.service.feign.UserService;
import com.adc.da.common.model.domain.RoleDO;
import com.adc.da.common.model.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO userDO = userService.getByUsername(username);
        List<RoleDO> roles = userService.getUserRole(userDO.getId());
        return new UserDetailsImpl(userDO, roles);
    }
}
