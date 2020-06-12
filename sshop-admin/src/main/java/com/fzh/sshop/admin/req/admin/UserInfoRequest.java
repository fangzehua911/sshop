package com.fzh.sshop.admin.req.admin;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Data
public class UserInfoRequest {


    private String userId;

    @NotBlank(message = "用户昵称")
    private String username;

    @NotBlank(message = "用户手机号")
    private String telephone;

    @NotBlank(message = "用户邮箱")
    private String mail;

    @NotBlank(message = "用户密码")
    private String password;

    @NotBlank(message = "备注")
    private String remark;

    @Min(0)
    private Integer depId;

    @Min(0)
    private Integer status;

    @NotBlank(message = "用户角色")
    private String roles;


}
