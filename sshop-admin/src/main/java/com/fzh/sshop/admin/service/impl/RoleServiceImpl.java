package com.fzh.sshop.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzh.sshop.admin.entity.Role;
import com.fzh.sshop.admin.entity.User;
import com.fzh.sshop.admin.mapper.RoleMapper;
import com.fzh.sshop.admin.req.RoleInfoRequest;
import com.fzh.sshop.admin.req.RoleListRequest;
import com.fzh.sshop.admin.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzh.sshop.request.SuperResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-13
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


    @Override
    public SuperResponse roleList(RoleListRequest request) {
        SuperResponse response = new SuperResponse();

        QueryWrapper<Role> wrapper = new QueryWrapper();
        Page<Role> pages = new Page<>(request.getPageNo(),request.getPageSize());
        IPage<Role> mapIPage = baseMapper.selectPage(pages, wrapper);

        response.setItems(mapIPage.getRecords());
        response.setTotals(mapIPage.getTotal());
        return response;
    }

    @Override
    public SuperResponse find(Integer roleId) {
        SuperResponse response = new SuperResponse();
        Role role  = baseMapper.selectById(roleId);
        if(null==role){
            response.setMessage("角色不存在!");
            response.setCode(-1000);
            return response;
        }
        response.setItem(role);
        return response;
    }

    @Override
    public SuperResponse insert(RoleInfoRequest request) {
        SuperResponse response = new SuperResponse();
        Role role = new Role();
        role.setRoleName(role.getRoleName());
        role.setStatus(request.getStatus());
        role.setCreateTime(LocalDate.now());
        role.setUpdateTime(LocalDate.now());
        baseMapper.insert(role);
        return response;
    }


    @Override
    public SuperResponse update(RoleInfoRequest request) {
        SuperResponse response = new SuperResponse();
        Role role = new Role();
        role.setRoleId(role.getRoleId());
        role.setRoleName(role.getRoleName());
        role.setStatus(request.getStatus());
        role.setUpdateTime(LocalDate.now());
        int rows = baseMapper.updateById(role);
        if(rows==0){
            response.setMessage("修改失败!");
            response.setCode(-1000);
            return response;
        }
        return response;
    }

    @Override
    public SuperResponse delete(Integer roleId) {

        SuperResponse response = new SuperResponse();
        int rows = baseMapper.deleteById(roleId);
        if(rows==0){
            response.setMessage("修改失败!");
            response.setCode(-1000);
            return response;
        }
        //TODO 删除之前所引用的角色

        return response;
    }
}
