package com.fzh.sshop.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class TSysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "用户名字")
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
    private Integer depId;

    @ApiModelProperty(value = "用户的状态 1 ：正常  0：冻结 2：删除")
    private Integer status;

    @ApiModelProperty(value = "操作时间")
    private Date createTime;

    @ApiModelProperty(value = "操作时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}