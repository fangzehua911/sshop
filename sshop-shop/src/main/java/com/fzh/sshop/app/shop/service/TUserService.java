package com.fzh.sshop.app.shop.service;

import com.fzh.sshop.app.shop.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-04
 */
public interface TUserService extends IService<TUser> {


    List<TUser> getUserAll();
}
