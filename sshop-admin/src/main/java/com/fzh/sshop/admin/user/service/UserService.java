package com.fzh.sshop.admin.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzh.sshop.admin.req.admin.UserListRequest;
import com.fzh.sshop.admin.user.entity.User;
import com.fzh.sshop.request.SuperResponse;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-11
 */
public interface UserService extends IService<User> {


    SuperResponse userList(UserListRequest request);

}
