package com.fzh.sshop.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fzh.sshop.app.entity.TBizMember;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-09
 */
public interface TBizMemberService extends IService<TBizMember> {

    List<TBizMember> list();

    int create(TBizMember member);


    String test(String name);


}
