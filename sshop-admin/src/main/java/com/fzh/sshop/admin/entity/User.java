package com.fzh.sshop.admin.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author fang
 * @since 2020-06-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TSysUser对象", description="")
@TableName("t_sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "用户账户")
    private String account;
    @ApiModelProperty(value = "头像")
    private String headImage;

    @ApiModelProperty(value = "用户昵称")
    private String username;

    @ApiModelProperty(value = "用户手机号")
    private String telephone;

    @ApiModelProperty(value = "用户邮箱")
    private String mail;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "用户部门表")
    private Integer deptId;
    @ApiModelProperty(value = "性别 0男1女")
    private Integer sex;

    @TableField(exist = false)
    private String deptName;

    @ApiModelProperty(value = "用户的状态 1 ：正常  0：冻结 2：删除")
    private Integer status;

    @ApiModelProperty(value = "添加时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
