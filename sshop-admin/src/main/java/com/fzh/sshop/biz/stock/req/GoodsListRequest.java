package com.fzh.sshop.biz.stock.req;

import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class GoodsListRequest extends SuperRequest {

    @Min(1)
    private Long pageNo;
    @Min(1)
    private Long PageSize;

    @ApiModelProperty(value = "分类ID")
    private String categoryId;

    @ApiModelProperty(value = "品牌ID")
    private String brandId;

    @ApiModelProperty(value = "商户编号")
    private String merchantNo;

    @ApiModelProperty(value = "商品编号")
    private String goodsNo;

    @ApiModelProperty(value = "商品简称")
    private String goodsName;

    @ApiModelProperty(value = "T,F 上架 下架")
    private String status;
}
