package com.fzh.sshop.admin.req;

import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.Min;

@Data
public class UserListRequest extends SuperRequest {

    @Min(1)
    private Long pageNo;
    @Min(1)
    private Long PageSize;

    @ApiModelProperty(name = "用户名称")
    private String userName;
    @ApiModelProperty(name = "用户手机")
    private String telephone;
    @ApiModelProperty(name = "部门")
    private Integer deptId;
    @ApiModelProperty(name = "状态")
    private Integer status;
}
