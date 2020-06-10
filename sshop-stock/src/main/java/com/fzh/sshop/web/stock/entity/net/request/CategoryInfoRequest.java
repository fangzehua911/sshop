package com.fzh.sshop.web.stock.entity.net.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CategoryInfoRequest {


    private Integer category_id;

    @NotBlank(message = "category_name不允许为空")
    @ApiModelProperty(value = "分类名称",required = true)
    private String  category_name;

    @NotBlank(message = "flag不允许为空")
    @ApiModelProperty(value = "状态 T,F",required = true)
    private String  flag;

    @NotBlank(message = "tcategory_img不允许为空")
    @ApiModelProperty(value = "分类图片",required = true)
    private String  category_img;

    @Min(value = 0,message = "parent_id不允许为空")
    @ApiModelProperty(value = "父级ID",required = true)
    private Integer parent_id;

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCategory_img() {
        return category_img;
    }

    public void setCategory_img(String category_img) {
        this.category_img = category_img;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }
}
