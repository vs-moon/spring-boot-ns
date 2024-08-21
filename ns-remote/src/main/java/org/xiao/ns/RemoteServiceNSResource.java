package org.xiao.ns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.common.box.domain.CommonResponse;
import org.xiao.cs.sso.box.domain.AuthoritySymbol;

@FeignClient(value = "ns-resource", path = "ns-resource")
public interface RemoteServiceNSResource {

  @PostMapping("/remote/orp/select")
  CommonResponse<AuthoritySymbol<String>> orpSelect(@RequestBody CommonRequest<AuthoritySymbol<Long>> commonRequest);

  @PostMapping("/remote/route/select")
  CommonResponse<Object> menuSelect(@RequestBody CommonRequest<Long[]> commonRequest);
}
