package com.fzh.sshop.app.service;
import com.fzh.sshop.app.entity.TBizMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fzh.sshop.app.entity.net.request.WeiXinLoginRequest;

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

    String test2(WeiXinLoginRequest request);

    String test3();

}
