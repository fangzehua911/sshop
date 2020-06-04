package com.fzh.sshop.app.shop.controller;


import com.fzh.sshop.app.shop.service.impl.TUserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author fang
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/shop/user")
public class TUserController {

    @Autowired
    private TUserServiceImpl service;


    @ApiOperation(value = "代理数据 √")
    @GetMapping(value = "/test")
    public List agentData() {

       return service.getUserAll();
    }
}

