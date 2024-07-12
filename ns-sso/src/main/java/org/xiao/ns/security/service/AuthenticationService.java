package org.xiao.ns.security.service;

import org.xiao.cs.sso.box.domain.AccountBody;
import org.xiao.cs.sso.box.domain.AccountRegister;

import java.security.Principal;

public interface AuthenticationService {
    int register(AccountRegister accountRegister);
    AccountBody profile(Principal principal);
    Object route();
}
