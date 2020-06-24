package com.fzh.sshop.stock.req;
import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsSpecsAttrValueRequest extends SuperRequest {

    @ApiModelProperty(value = "属性值ID")
    private Integer id;

    @ApiModelProperty(value = "属性ID")
    private Integer attrId;

}
