package com.fzh.sshop.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzh.sshop.admin.entity.Dept;
import com.fzh.sshop.admin.entity.Role;
import com.fzh.sshop.admin.entity.User;
import com.fzh.sshop.admin.mapper.DeptMapper;
import com.fzh.sshop.admin.mapper.UserMapper;
import com.fzh.sshop.admin.req.DeptInfoRequest;
import com.fzh.sshop.admin.req.DeptListRequest;
import com.fzh.sshop.admin.req.DeptRequest;
import com.fzh.sshop.admin.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzh.sshop.request.SuperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-13
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SuperResponse list(DeptListRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<Dept> wrapper = new QueryWrapper();
        Page<Dept> pages = new Page<>(request.getPageNo(),request.getPageSize());
        IPage<Dept> mapIPage = baseMapper.selectPage(pages, wrapper);
        response.setItems(mapIPage.getRecords());
        response.setTotals(mapIPage.getTotal());
        return response;
    }

    @Override
    public SuperResponse find(DeptRequest request) {
        SuperResponse response = new SuperResponse();
        Dept dept  = baseMapper.selectById(request.getDeptId());
        if(null==dept){
            response.setMessage("角色不存在!");
            response.setCode(-1000);
            return response;
        }
        response.setItem(dept);
        return response;
    }

    @Override
    public SuperResponse insert(DeptInfoRequest request) {
        SuperResponse response = new SuperResponse();
        Dept dept = new Dept();
        dept.setDeptName(request.getName());
        dept.setParentId(request.getParentId());
        dept.setLevel(request.getLevel());
        dept.setRemark(request.getRemark());
        int rows =  baseMapper.insert(dept);
        if(rows==0){
            response.setMessage("添加失败!");
            response.setCode(-1000);
            return response;
        }
       return response;
    }


    @Override
    public SuperResponse update(DeptInfoRequest request) {
        SuperResponse response = new SuperResponse();
        Dept dept = new Dept();
        dept.setDeptId(request.getId());
        dept.setDeptName(request.getName());
        dept.setParentId(request.getParentId());
        dept.setLevel(request.getLevel());
        dept.setRemark(request.getRemark());
        int rows =  baseMapper.updateById(dept);
        if(rows==0){
            response.setMessage("修改失败!");
            response.setCode(-1000);
            return response;
        }
        return response;
    }


    @Override
    public SuperResponse delete(DeptRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("dep_id",request.getDeptId());
        Integer users =  userMapper.selectCount(wrapper);
        if(users>0){
            response.setMessage("使用的部门不允许删除!");
            response.setCode(-1000);
            return response;
        }
        int rows = baseMapper.deleteById(request.getDeptId());
        if(rows==0){
            response.setMessage("删除失败!");
            response.setCode(-1000);
            return response;
        }
        return response;

    }

}