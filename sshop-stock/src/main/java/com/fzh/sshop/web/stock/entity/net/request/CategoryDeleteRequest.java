package com.fzh.sshop.web.stock.entity.net.request;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class CategoryDeleteRequest {

    @Min(value = 0,message = "category_id 不允许为空")
    private Integer category_id;


    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
