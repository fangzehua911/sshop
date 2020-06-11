package com.fzh.sshop.admin.service.impl;

import com.fzh.sshop.admin.entity.User;
import com.fzh.sshop.admin.mapper.UserMapper;
import com.fzh.sshop.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
