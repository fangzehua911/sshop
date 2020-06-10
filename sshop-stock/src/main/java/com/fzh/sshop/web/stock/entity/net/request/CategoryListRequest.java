package com.fzh.sshop.web.stock.entity.net.request;

import lombok.Data;

@Data
public class CategoryListRequest extends SuperRequest {

    private Integer category_id;

    private String  category_name;

    private String  flag;

    private String  category_img;

    private Integer parent_id;


}
