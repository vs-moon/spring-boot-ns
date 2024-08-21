package org.xiao.ns.domain.vo;

import org.springframework.beans.BeanUtils;
import org.xiao.ns.domain.po.Org;

import java.util.List;

public class OrgVO extends Org {

    private Boolean hasChildren = false;

    private List<OrgVO> children;

    public OrgVO() {}
    public OrgVO(Org org) {
        BeanUtils.copyProperties(org, this);
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public List<OrgVO> getChildren() {
        return children;
    }

    public void setChildren(List<OrgVO> children) {
        this.children = children;
    }
}
