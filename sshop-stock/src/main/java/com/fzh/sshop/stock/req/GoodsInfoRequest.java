package com.fzh.sshop.stock.req;
import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsInfoRequest extends SuperRequest {

    @ApiModelProperty(value = "商品ID")
    private Long goodsId;

    @ApiModelProperty(value = "分类ID")
    private Integer categoryId;

    @ApiModelProperty(value = "品牌ID")
    private Integer brandId;

    @ApiModelProperty(value = "商户编号")
    private String merchantNo;

    @ApiModelProperty(value = "商品编号")
    private String goodsNo;

    @ApiModelProperty(value = "商品简称")
    private String goodsName;

    @ApiModelProperty(value = "商品标题")
    private String goodsTitle;

    @ApiModelProperty(value = "商品主图")
    private String goodsImg;

    @ApiModelProperty(value = "图片码")
    private String goodsImgCode;

    @ApiModelProperty(value = "销售量")
    private Integer salesVol;

    @ApiModelProperty(value = "库存数量")
    private Integer stockVol;

}
