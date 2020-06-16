package com.fzh.sshop.admin.service;

import com.fzh.sshop.admin.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fzh.sshop.admin.req.*;
import com.fzh.sshop.request.SuperResponse;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-13
 */
public interface DeptService extends IService<Dept> {

    SuperResponse list(DeptListRequest request);

    SuperResponse listForSelect(DeptListRequest request);

    SuperResponse find(DeptRequest request);

    SuperResponse insert(DeptInfoRequest request);

    SuperResponse update(DeptInfoRequest request);

    SuperResponse delete(DeptRequest request);


}
