package com.fzh.sshop.stock.req;
import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class GoodsSpecsAttrInfoRequest extends SuperRequest {

    @ApiModelProperty(value = "属性ID")
    private Integer attrId;

    @ApiModelProperty(value = "分类ID")
    @Min(0)
    private Integer categoryId;

    @NotBlank
    @ApiModelProperty(value = "属性名称")
    private String attrName;

    @NotBlank
    @ApiModelProperty(value = "属性代码")
    private String attrCode;

    @NotBlank
    @ApiModelProperty(value = "属性状态 T,F")
    private String flag;

}
