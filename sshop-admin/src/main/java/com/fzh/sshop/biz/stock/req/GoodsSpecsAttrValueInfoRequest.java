package com.fzh.sshop.biz.stock.req;


import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class GoodsSpecsAttrValueInfoRequest extends SuperRequest {


    private Integer id;

    @Min(1)
    @ApiModelProperty(value = "属性ID")
    private Integer attrId;

    @NotBlank
    @ApiModelProperty(value = "属性值")
    private String attrValue;
    @NotBlank
    @ApiModelProperty(value = "排序号")
    private Integer sort;
}
