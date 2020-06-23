package com.fzh.sshop.stock.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TBizGoods对象", description="商品表")
public class TBizGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品ID")
    @TableId(value = "goods_id", type = IdType.AUTO)
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

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
