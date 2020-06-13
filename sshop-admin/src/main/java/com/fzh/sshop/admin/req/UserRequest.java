package com.fzh.sshop.admin.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRequest {

    @NotBlank
    @ApiModelProperty(value = "用户ID",required = true)
    private String userId;

}
