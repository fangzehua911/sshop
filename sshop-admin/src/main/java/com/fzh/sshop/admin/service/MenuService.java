package com.fzh.sshop.admin.service;

import com.fzh.sshop.admin.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fzh.sshop.admin.req.*;
import com.fzh.sshop.request.SuperResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-13
 */
public interface MenuService extends IService<Menu> {

    SuperResponse list(MenuListRequest request);

    SuperResponse find(MenuRequest request);

    SuperResponse insert(MenuInfoRequest request);

    SuperResponse update(MenuInfoRequest request);

    SuperResponse delete(MenuRequest request);

}
