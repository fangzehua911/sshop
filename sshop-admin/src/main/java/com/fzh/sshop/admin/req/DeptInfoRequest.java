package com.fzh.sshop.admin.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class DeptInfoRequest extends SuperRequest {


    @ApiModelProperty(value = "部门ID")
    private Integer deptId;

    @ApiModelProperty(value = "部门名称")
    @NotBlank
    private String deptName;

    @ApiModelProperty(value = "上级ID")
    @Min(0)
    private Integer parentId;
    @Min(0)
    @ApiModelProperty(value = "层级")
    private Integer level;

    @ApiModelProperty(value = "备注")
    private String remark;
}
