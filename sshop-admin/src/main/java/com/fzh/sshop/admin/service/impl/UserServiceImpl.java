package com.fzh.sshop.admin.service.impl;

import com.alibaba.nacos.common.utils.Md5Utils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzh.sshop.admin.entity.RoleUser;
import com.fzh.sshop.admin.entity.User;
import com.fzh.sshop.admin.mapper.DeptMapper;
import com.fzh.sshop.admin.mapper.RoleUserMapper;
import com.fzh.sshop.admin.mapper.UserMapper;
import com.fzh.sshop.admin.req.UserInfoRequest;
import com.fzh.sshop.admin.req.UserListRequest;
import com.fzh.sshop.admin.req.UserRequest;
import com.fzh.sshop.admin.service.UserService;
import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  系统用户服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RoleUserServiceImpl roleUserService;
    @Autowired
    private DeptMapper deptMapper;


    @Override
    public SuperResponse list(UserListRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<User> wrapper = new QueryWrapper();
        Page<User> pages = new Page<>(request.getPageNo(),request.getPageSize());
        IPage<User> mapIPage = baseMapper.selectPage(pages, wrapper);
        List<User> list = mapIPage.getRecords();
        for(User user:list){
            user.setDeptName(deptMapper.selectById(user.getDeptId()).getName());
        }
        response.setItems(list);
        response.setTotals(mapIPage.getTotal());
        return response;
    }


    @Override
    public SuperResponse find(UserRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<User> wrapper = new QueryWrapper();
        User user  = baseMapper.selectOne(wrapper.eq("user_id",request.getUserId()));
        if(null==user){
            response.setMessage("用户不存在!");
            response.setCode(-1000);
            return response;
        }
        response.setItem(user);
        return response;
    }


    @Override
    @Transactional
    public SuperResponse insert(UserInfoRequest request) {
        SuperResponse response = new SuperResponse();

        try {
            String user_id = IdUtils.getUUID();
            User user = new User();
            user.setUserId(user_id);
            user.setUsername(request.getUsername());
            user.setPassword(Md5Utils.getMD5(request.getPassword(),"utf-8"));
            user.setDeptId(request.getDeptId());
            user.setMail(request.getMail());
            user.setStatus(request.getStatus());
            user.setTelephone(request.getTelephone());
            user.setRemark(request.getRemark());
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            String roles[] = request.getRoles().split(",");
            for(String role_id:roles){
                //TODO 角色赋权

            }

            baseMapper.insert(user);

        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return response;
    }


    @Override
    public SuperResponse update(UserInfoRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_id",request.getUserId());
        try {
            User user = new User();
            user.setUserId(request.getUserId());
            user.setUsername(request.getUsername());
            //user.setPassword(Md5Utils.getMD5(request.getPassword(),"utf-8"));
            user.setDeptId(request.getDeptId());
            user.setMail(request.getMail());
            user.setStatus(request.getStatus());
            user.setTelephone(request.getTelephone());
            user.setRemark(request.getRemark());
            user.setUpdateTime(LocalDateTime.now());
            String roles[] = request.getRoles().split(",");
            RoleUser userRole = null;
            //TODO 删除之前的角色
            roleUserService.deleteRoleUser(request.getUserId());
            for(String role_id:roles){
                //TODO 重新角色赋权
                userRole = new RoleUser();
                userRole.setUserId(user.getUserId());
                userRole.setRoleId(Integer.parseInt(role_id));
                roleUserService.insertRoleUser(userRole);
            }

            baseMapper.update(user,wrapper);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return response;
    }


    @Override
    public SuperResponse delete(UserRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<User> wrapper = new QueryWrapper();
        int  rows = baseMapper.delete(wrapper.eq("user_id",request.getUserId()));
        if(rows==0){
            response.setMessage("删除失败");
            response.setCode(-1000);
            return response;
        }
        //
        //TODO 删除关联的角色
        roleUserService.deleteRoleUser(request.getUserId());
        return response;
    }


}
