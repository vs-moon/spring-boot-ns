package org.xiao.ns.security.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.sso.box.domain.AccountBody;
import org.xiao.cs.sso.box.domain.AccountRegister;
import org.xiao.cs.sso.box.utils.EncoderUtils;
import org.xiao.ns.domain.po.Member;
import org.xiao.ns.manage.MemberManage;
import org.xiao.ns.security.manage.AuthenticationManage;
import org.xiao.ns.security.service.AuthenticationService;

import java.security.Principal;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Resource
    MemberManage memberManage;
    @Resource
    AuthenticationManage authenticationManage;

    @Override
    public int register(AccountRegister accountRegister) {
        Member member = new Member();
        member.setUsername(accountRegister.getUsername());
        member.setPassword(EncoderUtils.encode(accountRegister.getPassword()));
        return memberManage.insertOne(member);
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
