package com.fzh.sshop.stock.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TBizGoodsPicture对象", description="")
public class TBizGoodsPicture implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "商品编号")
    private String goodsNo;

    @ApiModelProperty(value = "图片地址")
    private String goodsImg;

    @ApiModelProperty(value = "百度图片标识")
    private String goodsImgCode;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
