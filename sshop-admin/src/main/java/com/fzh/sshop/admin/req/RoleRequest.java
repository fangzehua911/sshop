package com.fzh.sshop.admin.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class RoleRequest {

    @Min(0)
    @ApiModelProperty(value = "角色ID",required = true)
    private Integer roleId;

}
