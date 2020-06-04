package com.fzh.sshop.app.shop.service.impl;

import com.fzh.sshop.app.shop.entity.TUser;
import com.fzh.sshop.app.shop.mapper.TUserMapper;
import com.fzh.sshop.app.shop.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-04
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {



    @Override
    public List<TUser> getUserAll() {
        return list(null);
    }
}
