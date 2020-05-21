package com.fzh.sshop.shop.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class TestController {

    @GetMapping("/test/{name}")
    public String test(@PathVariable("name") String name){
        int a = 1/0;
        return "ok-order2:"+name;
    }
}



