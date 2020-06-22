package com.fzh.sshop.admin.req;

import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class MenuInfoRequest extends SuperRequest {

    private Integer menuId;
    @Min(0)
    private Integer menuPid;
    @NotBlank
    private String menuName;
    @NotBlank
    private String menuCode;
    @ApiModelProperty(value = "是否按钮T,F")
    @NotBlank
    private String isButton;
    @Min(0)
    private Integer level;
    @NotBlank
    private String menuUrl;

    private String menuIcon;
    @Min(0)
    private Integer orderno;
    @NotBlank
    @ApiModelProperty(value = "0可用1不可用")
    private String status;

}
