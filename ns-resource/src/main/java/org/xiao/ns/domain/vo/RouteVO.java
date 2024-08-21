package org.xiao.ns.domain.vo;

import org.springframework.beans.BeanUtils;
import org.xiao.ns.domain.po.Route;

import java.util.List;

public class RouteVO extends Route {

    private Boolean hasChildren = false;

    private List<RouteVO> children;

    public RouteVO() {}
    public RouteVO(Route route) {
        BeanUtils.copyProperties(route, this);
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public List<RouteVO> getChildren() {
        return children;
    }

    public void setChildren(List<RouteVO> children) {
        this.children = children;
    }
}
