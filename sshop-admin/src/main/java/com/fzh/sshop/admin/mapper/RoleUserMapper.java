package com.fzh.sshop.admin.mapper;

import com.fzh.sshop.admin.entity.RoleUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户角色关联表 Mapper 接口
 * </p>
 *
 * @author fang
 * @since 2020-06-13
 */
@Mapper
public interface RoleUserMapper extends BaseMapper<RoleUser> {

}
