package com.fzh.sshop.request;

import lombok.Data;

import java.util.List;

@Data
public class SuperResponse<T>{

    private Integer code = 200;
    private String message = "操作成功";
    private T item;
    private List<T> items;
    private Long totals;
    private Long time = System.currentTimeMillis();

}
