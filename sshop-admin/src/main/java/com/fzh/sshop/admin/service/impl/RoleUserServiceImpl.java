package com.fzh.sshop.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fzh.sshop.admin.entity.RoleUser;
import com.fzh.sshop.admin.mapper.RoleUserMapper;
import com.fzh.sshop.admin.service.RoleUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

    @Override
    public boolean deleteRoleUser(String user_id) {
        QueryWrapper<RoleUser> wrapper = new QueryWrapper();
        wrapper.eq("user_id",user_id);
        int rows = baseMapper.delete(wrapper);
        return true;
    }

    @Override
    public boolean insertRoleUser(RoleUser roleUser) {
        int rows =  baseMapper.insert(roleUser);
        return true;
    }
}
