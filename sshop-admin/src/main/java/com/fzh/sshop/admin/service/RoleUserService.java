package com.fzh.sshop.admin.service;

import com.fzh.sshop.admin.entity.RoleUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-13
 */
public interface RoleUserService extends IService<RoleUser> {

    boolean deleteRoleUser(String user_id);

    boolean insertRoleUser(RoleUser roleUser);

}
