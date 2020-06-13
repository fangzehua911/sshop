package com.fzh.sshop.admin.req;

import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class RoleInfoRequest extends SuperRequest {

    private Integer roleId;

    @ApiModelProperty(value = "角色名称")
    @NotBlank
    private String roleName;

    @ApiModelProperty(value = "角色代码")
    @NotBlank
    private String roleCode;

    @ApiModelProperty(value = "0可用 -1 停用")
    @Min(-1)
    private Integer status;


}
