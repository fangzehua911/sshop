package com.fzh.sshop.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fzh.sshop.admin.entity.Role;
import com.fzh.sshop.admin.entity.RoleUser;
import com.fzh.sshop.admin.mapper.RoleMapper;
import com.fzh.sshop.admin.mapper.RoleUserMapper;
import com.fzh.sshop.admin.service.RoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-13
 */
@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean deleteRoleUser(String userId) {
        QueryWrapper<RoleUser> wrapper = new QueryWrapper();
        wrapper.eq("user_id",userId);
        int rows = baseMapper.delete(wrapper);
        return true;
    }

    @Override
    public boolean insertRoleUser(RoleUser roleUser) {
        int rows =  baseMapper.insert(roleUser);
        return true;
    }


    @Override
    public String findRolesByUserId(String userId) {
        String roles = "";
        QueryWrapper<RoleUser> wrapper = new QueryWrapper();
        wrapper.eq("user_id",userId);
        List<RoleUser> roleUserList =   baseMapper.selectList(wrapper);
        for(RoleUser roleUser:roleUserList){
            roles = roles+","+roleMapper.selectById(roleUser.getRoleId()).getRoleName();
        }
        return roles.substring(1);
    }
}
