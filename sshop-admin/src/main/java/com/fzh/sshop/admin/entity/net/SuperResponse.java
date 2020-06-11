package com.fzh.sshop.admin.entity.net;

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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Long getTotals() {
        return totals;
    }

    public void setTotals(Long totals) {
        this.totals = totals;
    }
}
