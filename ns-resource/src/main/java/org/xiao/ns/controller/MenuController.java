package org.xiao.ns.controller;

import com.github.pagehelper.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.common.box.domain.CommonRequestPaging;
import org.xiao.cs.db.box.service.entry.EntryService;
import org.xiao.ns.domain.po.Menu;
import org.xiao.ns.service.MenuService;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController implements EntryService<Menu> {

    @Resource
    MenuService menuService;

    @Override
    @PostMapping("deleteOne")
    public int deleteOne(@RequestBody CommonRequest<Long> record) {
        return menuService.deleteOne(record.getArgs());
    }

    @Override
    @PostMapping("deleteMany")
    public int deleteMany(@RequestBody CommonRequest<List<Long>> record) {
        return menuService.deleteMany(record.getArgs());
    }

    @Override
    @PostMapping("insertOne")
    public int insertOne(@RequestBody CommonRequest<Menu> record) {
        return menuService.insertOne(record.getArgs());
    }

    @Override
    @PostMapping("insertMany")
    public int insertMany(@RequestBody CommonRequest<List<Menu>> record) {
        return menuService.insertMany(record.getArgs());
    }

    @Override
    @PostMapping("selectOne")
    public Menu selectOne(@RequestBody CommonRequest<Long> record) {
        return menuService.selectOne(record.getArgs());
    }

    @Override
    @PostMapping("selectMany")
    public List<Menu> selectMany(@RequestBody CommonRequest<Menu> record) {
        return menuService.selectMany(record.getArgs());
    }

    @Override
    @PostMapping("selectPage")
    public Page<Menu> selectPage(@RequestBody CommonRequestPaging<Menu> record) {
        return menuService.selectPage(record.getArgs(), record.getPaging().getPageNum(), record.getPaging().getPageSize());
    }

    @Override
    @PostMapping("updateOne")
    public int updateOne(@RequestBody CommonRequest<Menu> record) {
        return menuService.updateOne(record.getArgs());
    }

    @Override
    @PostMapping("updateMany")
    public int updateMany(@RequestBody CommonRequest<List<Menu>> record) {
        return menuService.updateMany(record.getArgs());
    }

    @Override
    @PostMapping("validOne")
    public int validOne(@RequestBody CommonRequest<ArgsState<Long, String>> record) {
        return menuService.validOne(record.getArgs());
    }

    @Override
    @PostMapping("validMany")
    public int validMany(@RequestBody CommonRequest<ArgsState.Many<Long, String>> record) {
        return menuService.validMany(record.getArgs());
    }
}
