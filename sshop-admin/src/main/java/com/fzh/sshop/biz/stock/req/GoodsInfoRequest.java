package com.fzh.sshop.biz.stock.req;
import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class GoodsInfoRequest extends SuperRequest {

    @ApiModelProperty(value = "商品ID")
    private Long goodsId;

    @Min(1)
    @ApiModelProperty(value = "分类ID")
    private Integer categoryId;

    @Min(1)
    @ApiModelProperty(value = "品牌ID")
    private Integer brandId;

    @NotBlank
    @ApiModelProperty(value = "商户编号")
    private String merchantNo;
    @NotBlank
    @ApiModelProperty(value = "商品编号")
    private String goodsNo;

    @NotBlank
    @ApiModelProperty(value = "商品简称")
    private String goodsName;

    @NotBlank
    @ApiModelProperty(value = "商品标题")
    private String goodsTitle;

    @NotBlank
    @ApiModelProperty(value = "商品主图")
    private String goodsImg;

    @ApiModelProperty(value = "销售量")
    private Integer salesVol;

    @ApiModelProperty(value = "T,F 上架 下架")
    @NotBlank
    private String status;

    @ApiModelProperty(value = "库存数量")
    private Integer stockVol;

    private String goodsImgs;

}
