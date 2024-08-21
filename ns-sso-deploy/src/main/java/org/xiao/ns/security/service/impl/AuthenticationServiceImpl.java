package org.xiao.ns.security.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.sso.box.domain.AccountBody;
import org.xiao.cs.sso.box.domain.AccountRegister;
import org.xiao.cs.sso.box.utils.EncoderUtils;
import org.xiao.ns.domain.po.User;
import org.xiao.ns.manage.UserManage;
import org.xiao.ns.security.manage.AuthenticationManage;
import org.xiao.ns.security.service.AuthenticationService;

import java.security.Principal;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Resource
    UserManage userManage;
    @Resource
    AuthenticationManage authenticationManage;

    @Override
    public int register(AccountRegister accountRegister) {
        User user = new User();
        user.setUsername(accountRegister.getUsername());
        user.setPassword(EncoderUtils.encode(accountRegister.getPassword()));
        return userManage.insertOne(user);
    }

    @Override
    public AccountBody profile(Principal principal) {
        return authenticationManage.loadUserByUsername(principal.getName());
    }

    @Override
    public Object route() {
        return authenticationManage.getRoute();
    }
}
