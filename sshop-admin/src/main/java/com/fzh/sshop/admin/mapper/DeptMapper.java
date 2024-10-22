package com.fzh.sshop.admin.mapper;

import com.fzh.sshop.admin.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author fang
 * @since 2020-06-13
 */
@Mapper
@Repository
public interface DeptMapper extends BaseMapper<Dept> {

}
