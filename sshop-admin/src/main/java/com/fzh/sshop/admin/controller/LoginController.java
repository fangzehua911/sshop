package com.fzh.sshop.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.admin.service.impl.LoginServiceImpl;
import com.fzh.sshop.admin.req.LoginRequest;
import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.utils.RedisUtil;
import com.fzh.sshop.utils.verify.IVerifyCodeGen;
import com.fzh.sshop.utils.verify.VerifyCode;
import com.fzh.sshop.utils.verify.impl.SimpleCharVerifyCodeGenImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * @author fang
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/admin/login")
@Api(value = "后台管理",tags = {"admin-登录"})
@Slf4j
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("")
    @ApiOperation(value = "用户登录" ,notes = "")
    public SuperResponse userLogin(@Valid @RequestBody LoginRequest request){
        return loginService.userLogin(request);
    }



    @GetMapping("/verifyCode")
    @ApiOperation(value = "获取验证码" ,notes = "")
    public String  verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode().toUpperCase();
            log.info(code);
            //将VerifyCode绑定session
            redisUtil.set("VCode:"+code,code,60);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            log.info("", e);
        }

        return "succ";
    }

}
