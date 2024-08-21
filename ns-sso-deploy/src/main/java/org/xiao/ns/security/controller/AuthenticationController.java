package org.xiao.ns.security.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.sso.box.domain.AccountBody;
import org.xiao.cs.sso.box.domain.AccountRegister;
import org.xiao.ns.security.service.AuthenticationService;

import java.security.Principal;

@RestController
public class AuthenticationController {

    @Resource
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public int register(@RequestBody CommonRequest<AccountRegister> commonRequest) {
        return authenticationService.register(commonRequest.getArgs());
    }

    @GetMapping("/profile")
    public AccountBody profile(Principal principal) {
        return authenticationService.profile(principal);
    }

    @GetMapping("/route")
    public Object route() {
        return authenticationService.route();
    }
}
