package com.fzh.sshop.admin.req;

import com.fzh.sshop.request.SuperRequest;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class MenuInfoRequest extends SuperRequest {

    private Integer menuId;

    @Min(0)
    private Integer menuPid;

    @NotBlank
    private String menuName;
    @NotBlank
    private String menuCode;

    @Min(0)
    private Integer level;
    @NotBlank
    private String menuUrl;
    @NotBlank
    private String menuIcon;
    @Min(0)
    private Integer orderno;
    @Min(0)
    @ApiModelProperty(value = "0可用1不可用")
    private Integer status;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(Integer menuPid) {
        this.menuPid = menuPid;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
