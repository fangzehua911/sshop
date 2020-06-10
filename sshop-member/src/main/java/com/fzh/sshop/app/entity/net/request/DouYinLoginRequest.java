package com.fzh.sshop.app.entity.net.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value="DouYinLoginRequest",description="小程序登录参数")
public class DouYinLoginRequest extends SuperRequest {

    @NotBlank(message = "open_id不允许为空")
    @ApiModelProperty(value = "openid",required = true)
    private String opend_id;

    @NotBlank(message = "token_code不允许为空")
    @ApiModelProperty(value = "微信code",required = true)
    private String token_code;

    @ApiModelProperty(value = "城市")
    private String city;


}
