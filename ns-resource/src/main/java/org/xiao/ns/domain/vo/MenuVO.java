package org.xiao.ns.domain.vo;

import org.springframework.beans.BeanUtils;
import org.xiao.ns.domain.po.Menu;

import java.util.List;

public class MenuVO extends Menu {

    private Boolean hasChildren = false;

    private List<MenuVO> children;

    public MenuVO() {}
    public MenuVO(Menu menu) {
        BeanUtils.copyProperties(menu, this);
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public List<MenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVO> children) {
        this.children = children;
    }
}
