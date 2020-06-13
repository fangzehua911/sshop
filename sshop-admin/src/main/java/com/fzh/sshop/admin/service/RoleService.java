package com.fzh.sshop.admin.service;

import com.fzh.sshop.admin.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fzh.sshop.admin.req.RoleInfoRequest;
import com.fzh.sshop.admin.req.RoleListRequest;
import com.fzh.sshop.admin.req.RoleRequest;
import com.fzh.sshop.admin.req.UserInfoRequest;
import com.fzh.sshop.request.SuperResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-13
 */
public interface RoleService extends IService<Role> {

    SuperResponse list(RoleListRequest request);

    SuperResponse find(RoleRequest request);

    SuperResponse insert(RoleInfoRequest request);

    SuperResponse update(RoleInfoRequest request);

    SuperResponse delete(RoleRequest request);

}
