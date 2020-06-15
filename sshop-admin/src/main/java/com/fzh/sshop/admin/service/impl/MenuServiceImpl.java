package com.fzh.sshop.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzh.sshop.admin.entity.Dept;
import com.fzh.sshop.admin.entity.Menu;
import com.fzh.sshop.admin.entity.User;
import com.fzh.sshop.admin.mapper.MenuMapper;
import com.fzh.sshop.admin.req.MenuInfoRequest;
import com.fzh.sshop.admin.req.MenuListRequest;
import com.fzh.sshop.admin.req.MenuRequest;
import com.fzh.sshop.admin.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzh.sshop.request.SuperResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-13
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Override
    public SuperResponse list(MenuListRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<Menu> wrapper = new QueryWrapper();
        Page<Menu> pages = new Page<>(request.getPageNo(),request.getPageSize());
        wrapper.eq("menu_pid",0);
        IPage<Menu> mapIPage = baseMapper.selectPage(pages, wrapper);
        List<Menu> menuList = mapIPage.getRecords();
        for(Menu menu:menuList){
            wrapper = new QueryWrapper();
            menu.setTrees(baseMapper.selectList(wrapper.eq("menu_pid",menu.getMenuId()).orderByAsc("level")));
            for(Menu menu1:menu.getTrees()){
                wrapper = new QueryWrapper();
                menu1.setTrees(baseMapper.selectList(wrapper.eq("menu_pid",menu1.getMenuId()).orderByAsc("level")));
            }
        }
        response.setItems(menuList);
        response.setTotals(mapIPage.getTotal());
        return response;
    }

    @Override
    public SuperResponse find(MenuRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<Menu> wrapper = new QueryWrapper();
        Menu menu  = baseMapper.selectById(request.getMenuId());
        if(null==menu){
            response.setMessage("用户不存在!");
            response.setCode(-1000);
            return response;
        }
        response.setItem(menu);
        return response;
    }

    @Override
    public SuperResponse insert(MenuInfoRequest request) {
        SuperResponse response = new SuperResponse();
        Menu menu = new Menu();
        menu.setMenuName(request.getMenuName());
        menu.setMenuCode(request.getMenuCode());
        menu.setMenuPid(request.getMenuPid());
        menu.setLevel(request.getLevel());
        menu.setMenuIcon(request.getMenuIcon());
        menu.setMenuUrl(request.getMenuUrl());
        int rows =  baseMapper.insert(menu);
        if(rows!=1){
           response.setMessage("添加失败!");
           response.setCode(-1000);
           return response;
        }
        return response;
    }

    @Override
    public SuperResponse update(MenuInfoRequest request) {
        SuperResponse response = new SuperResponse();
        Menu menu = new Menu();
        menu.setMenuId(request.getMenuId());
        menu.setMenuName(request.getMenuName());
        menu.setMenuCode(request.getMenuCode());
        menu.setMenuPid(request.getMenuPid());
        menu.setLevel(request.getLevel());
        menu.setMenuIcon(request.getMenuIcon());
        menu.setMenuUrl(request.getMenuUrl());
        int rows =  baseMapper.insert(menu);
        if(rows!=1){
            response.setMessage("修改失败!");
            response.setCode(-1000);
            return response;
        }
        return response;

    }

    @Override
    public SuperResponse delete(MenuRequest request) {
        SuperResponse response = new SuperResponse();
        //TODO 删除所有角色引用的菜单

        int rows = baseMapper.deleteById(request.getMenuId());
        if(rows!=1){
            response.setMessage("删除失败");
            response.setCode(-1000);
            return response;
        }
        return response;
    }

}
