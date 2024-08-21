package org.xiao.ns.remote;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.ns.domain.po.Route;
import org.xiao.ns.service.RouteService;

import java.util.List;

@RestController
@RequestMapping("/remote/route")
public class RemoteServiceRoute {
    @Resource
    RouteService routeService;

    @PostMapping("/select")
    public List<Route> assemble(@RequestBody CommonRequest<Long[]> commonRequest) {
        String app = commonRequest.getSign();
        return routeService.selectIn(app, commonRequest.getArgs());
    }
}
