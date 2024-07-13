package org.xiao.ns.service.impl;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.ns.domain.po.Menu;
import org.xiao.ns.domain.vo.MenuVO;
import org.xiao.ns.manage.MenuManage;
import org.xiao.ns.service.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

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
    public List<? extends Menu> selectMany(Menu record) {
        List<Menu> menus = menuManage.selectMany(record);

//        return convert(menus, menu -> {
//            MenuVO menuVO = new MenuVO(menu);
//            if (menuManage.countByKey(menu.getId()) > 0) {
//                menuVO.setHasChildren(true);
//            }
//            return menuVO;
//        });


        return convert(menus, menu -> hasChildren(menu, MenuVO::new, (menuVO) -> {
            if (menuManage.countByKey(menu.getId()) > 0) {
                menuVO.setHasChildren(true);
            }
        }));
    }

    @Override
    public PageInfo<? extends Menu> selectPage(Menu record, int pageNum, int pageSize) {
//        return menuManage.selectPage(record, pageNum, pageSize).convert(menu -> {
//            MenuVO menuVO = new MenuVO(menu);
//            if (menuManage.countByKey(menu.getId()) > 0) {
//                menuVO.setHasChildren(true);
//            }
//            return menuVO;
//        });

        return menuManage.selectPage(record, pageNum, pageSize).convert(menu -> hasChildren(menu, MenuVO::new, (menuVO) -> {
            if (menuManage.countByKey(menu.getId()) > 0) {
                menuVO.setHasChildren(true);
            }
        }));
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

    public <R extends T, T> R hasChildren(T args, Function<T, R> function, Consumer<R> consumer) {
        R apply = function.apply(args);
        consumer.accept(apply);
        return apply;
    }

    public <R extends T, T> List<R> convert(List<T> args, Function<T, R> function) {
        List<R> list = new ArrayList<>(args.size());
        for (T t : args) {
            list.add(function.apply(t));
        }
        return list;
    }
}
