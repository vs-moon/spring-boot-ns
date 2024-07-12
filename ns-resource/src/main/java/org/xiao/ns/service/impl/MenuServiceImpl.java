package org.xiao.ns.service.impl;

import com.github.pagehelper.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.ns.domain.po.Menu;
import org.xiao.ns.manage.MenuManage;
import org.xiao.ns.service.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    MenuManage menuManage;

    @Override
    public int deleteOne(Long record) {
        return menuManage.deleteOne(record);
    }

    @Override
    public int deleteMany(List<Long> record) {
        return menuManage.deleteMany(record);
    }

    @Override
    public int insertOne(Menu record) {
        return menuManage.insertOne(record);
    }

    @Override
    public int insertMany(List<Menu> record) {
        return menuManage.insertMany(record);
    }

    @Override
    public Menu selectOne(Long record) {
        return menuManage.selectOne(record);
    }

    @Override
    public List<Menu> selectMany(Menu record) {
        return menuManage.selectMany(record);
    }

    @Override
    public Page<Menu> selectPage(Menu record, int pageNum, int pageSize) {
        return menuManage.selectPage(record, pageNum, pageSize);
    }

    @Override
    public int updateOne(Menu record) {
        return menuManage.updateOne(record);
    }

    @Override
    public int updateMany(List<Menu> record) {
        return menuManage.updateMany(record);
    }

    @Override
    public int validOne(ArgsState<Long, String> record) {
        return menuManage.validOne(record);
    }

    @Override
    public int validMany(ArgsState.Many<Long, String> record) {
        return menuManage.validMany(record);
    }

    @Override
    public List<Menu> selectIn(String source, Long[] menuIdArray) {
        return menuManage.selectIn(source, menuIdArray);
    }
}
