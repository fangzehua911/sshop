package com.fzh.sshop.app.controller;


import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.app.entity.net.request.WeiXinLoginRequest;
import com.fzh.sshop.app.service.impl.TBizMemberServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fang
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/member")
public class TBizMemberController {

    @Autowired
    private TBizMemberServiceImpl tBizMemberService;

    @GetMapping("/list")
    public String getList(){

        return JSONObject.toJSONString(tBizMemberService.list());
    }

    @PostMapping("/weixinLogin")
    @ApiOperation(value = "微信用户登录" ,notes = "不存在自动注册,返回用户对象")
    public String wxLogin(@Valid @RequestBody WeiXinLoginRequest request){

        return JSONObject.toJSONString(tBizMemberService.create(null));
    }

    @PostMapping("/douyinLogin")
    @ApiOperation(value = "抖音用户登录" ,notes = "不存在自动注册,返回用户对象")
    public String dyLogin(@Valid @RequestBody WeiXinLoginRequest request){

        return JSONObject.toJSONString(tBizMemberService.create(null));
    }

    @PostMapping("/kuaishouLogin")
    @ApiOperation(value = "快手用户登录" ,notes = "不存在自动注册,返回用户对象")
    public String ksLogin(@Valid @RequestBody WeiXinLoginRequest request){

        return JSONObject.toJSONString(tBizMemberService.create(null));
    }

    @GetMapping("/test/{name}")
    @ApiOperation(value = "快手用户登录" ,notes = "不存在自动注册,返回用户对象")
    public String test(@PathVariable("name") String name){

        return tBizMemberService.test(name);
    }

    @PostMapping("/test2")
    @ApiOperation(value = "快手用户登录" ,notes = "不存在自动注册,返回用户对象")
    public String test2(@RequestBody WeiXinLoginRequest request ){
        return tBizMemberService.test2(request);
    }

}

