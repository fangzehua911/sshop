package com.fzh.sshop.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fzh.sshop.admin.entity.User;
import com.fzh.sshop.admin.req.UserInfoRequest;
import com.fzh.sshop.admin.req.UserListRequest;
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

    SuperResponse find(String userId);

    SuperResponse insert(UserInfoRequest request);

    SuperResponse update(UserInfoRequest request);

    SuperResponse delete(String userId);

}
