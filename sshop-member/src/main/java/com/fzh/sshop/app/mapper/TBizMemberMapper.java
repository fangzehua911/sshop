package com.fzh.sshop.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fzh.sshop.app.entity.TBizMember;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fang
 * @since 2020-06-09
 */
@Mapper
public interface TBizMemberMapper extends BaseMapper<TBizMember> {

    String getMembers(int id);

}
