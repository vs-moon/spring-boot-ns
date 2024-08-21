package org.xiao.ns.security.service.impl;

import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.xiao.ns.security.manage.AuthenticationManage;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    AuthenticationManage authenticationManage;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return authenticationManage.loadUserByUsername(username);
    }
}
